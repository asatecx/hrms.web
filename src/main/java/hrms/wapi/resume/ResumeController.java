package hrms.wapi.resume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import af.base.controller.BaseController;
import af.base.service.PdfReportService;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.hrms.wapi.login<br/>
 * Class         ResumeController<br/>
 * Summary       ログイン<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/03/28       tang-xf      Add          1.0.0      新規作成<br/>
 ************************************************************************/
@RestController
public class ResumeController extends BaseController  {
	@Autowired
    @Qualifier("main.pdfReportService")
    protected PdfReportService pdfReportService;

    @RequestMapping(value = "/resume", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public void showPdf(HttpServletResponse response) throws IOException {
        //需要填充的数据
        Map<String, Object> data = new HashMap<>(16);
        data.put("name", "kevin");
        String content = pdfReportService.freeMarkerRender(data, "freemarker.ftl");
        //创建pdf
        String dest = pdfReportService.createPdf(content, "test.pdf");
        // 读取pdf并预览
        readPdf(response, dest);
    }

    /**
     * 读取本地pdf,这里设置的是预览
     */
    private void readPdf(HttpServletResponse response, String dest) {
        response.reset();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename= file");
//        response.setHeader("content-disposition", "attachment;filename=" + dest);
        response.setHeader("Access-Control-Allow-Origin", "*");
        try {
            File file = new File(dest);
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}