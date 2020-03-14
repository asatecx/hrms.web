package hrms.wapi.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import af.base.controller.BaseController;
import af.base.model.JsonModel;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.node.wapi<br/>
 * Class         UploadFileController<br/>
 * Summary       ファイルアップロードコントローラ<br/>
 *
 * Date             Author      Category     Version     Note<br/>
 * 2020/03/11                   Add          1.0.0        新規作成<br/>
 ************************************************************************/
@Scope("request")
@RestController
public class UploadFileController extends BaseController {
    /**
     * save file
     * @param uploadfile uploadfile.
     * @param FILE_COMMENT FILE_COMMENT.
     * @return JsonModel
     * @throws IOException IOException.
     */
    @RequestMapping(value = "/video/upload", method = RequestMethod.PUT,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel upoad(@RequestParam MultipartFile uploadfile) throws IOException {
        if (uploadfile.isEmpty()) return new JsonModel(false, "No file updated");
        //サーバー側に一時保存
//        String tmpDir = MessageFormat.format(environment.getProperty("file.upload.video"), new Date());
        String tmpDir = MessageFormat.format(environment.getProperty("file.upload.video"), new Date());
        new File(tmpDir).mkdirs();
        String fileName = StringUtils.cleanPath(uploadfile.getOriginalFilename());
        Path tmPath = Paths.get(tmpDir + new File(fileName).getName());
        Files.copy(uploadfile.getInputStream(), tmPath, StandardCopyOption.REPLACE_EXISTING);

        return new JsonModel(true, this.getMessage("main.insert.ok"));
    }

}
