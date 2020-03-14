package af.base.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import af.base.exception.ReportException;
import af.base.exception.WebException;
import af.base.service.SimpleDaoService;
import af.base.util.Easy;
import af.base.util.HttpUtil;
import af.base.util.QueryUtil;
import af.base.util.StringUtil;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.base.action<br/>
 * Class         BaseAction<br/>
 * Summary       基本となるアクション<br/>
 *
 * Date             Author      Category     Version     Note<br/>
 * 2020/03/12       tang-xf     Add          1.0.0       新規作成<br/>
 ************************************************************************/
public class BaseController extends Easy {

    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    @Autowired
    @Qualifier("main.simpleDaoService")
    protected SimpleDaoService mainSimpleDaoService;

    /**
     * ORDER BY SQL文の作成 (For Relational DB)
     * @return ORDER BY SQL文
     */
    protected String composeOrderByClause(Map<String, Integer> sortInfo) {
        return QueryUtil.composeOrderByClause(sortInfo);
    }

    /**
     * MongoDB Sort作成 (For MongoDB)
     * @return Sort
     */
    protected Sort composeSortClause(Map<String, Integer> sortInfo) {
        if (sortInfo == null || sortInfo.isEmpty()) return null;
        List<Order> orders = new ArrayList<Order>();
        for (Map.Entry<String, Integer> item : sortInfo.entrySet()) {
            String prop = item.getKey();
            if (StringUtil.isBlank(prop)) continue;
            StringUtil.CheckSqlInjection(prop);
            if (prop.indexOf(' ') >= 0) {
                throw new WebException("sql injection risk");
            }

            Integer dir = item.getValue();
            Direction direction = (dir != null && dir < 0) ? Direction.DESC : Direction.ASC;
            orders.add(new Order(direction, prop));
        }

        if (orders.size() == 0) return null;
        return new Sort(orders);
    }

    /**
     * ファイルダウンロード
     * @param fileFullPath
     * @param fileDownloadName
     * @param isToOpen
     */
    protected ResponseEntity<Resource> downloadFile(String fileFullPath, String fileDownloadName, Boolean isToOpen) {
        try {
            File file = new File(fileFullPath);
            if (StringUtil.isBlank(fileDownloadName)) fileDownloadName = file.getName();

            Resource resource = new UrlResource(file.toURI());

            String disposition = null;
            if (isToOpen != null && isToOpen) disposition = "inline;filename=";
            else disposition = "attachment;filename=";
            disposition += HttpUtil.encodeURIComponent(fileDownloadName);

            return ResponseEntity.ok()
                    .header(HttpHeaders.PRAGMA, "no-cache")
                    .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                    .header(HttpHeaders.CONTENT_DISPOSITION, disposition)
                    .contentType(MediaType.parseMediaType(HttpUtil.getContentType(fileDownloadName)))
                    .contentLength((int) file.length())
                    .body(resource);
        } catch (Exception e) {
            Log.error("Failed to download file: " + fileFullPath);
            throw new MyReportException(e);
        }
    }

    @ExceptionHandler(MyReportException.class)
    public ResponseEntity<?> handleStorageFileNotFound(MyReportException exc) {
        return ResponseEntity.notFound().build();
    }

    protected class MyReportException extends ReportException {
        private static final long serialVersionUID = -1707067119990198161L;
        public MyReportException(Exception e) {
            super(e);
        }
    }
}
