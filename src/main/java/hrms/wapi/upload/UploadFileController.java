package hrms.wapi.upload;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import af.base.controller.BaseController;
import af.base.model.JsonModel;
import hrms.model.PeopleBase;
import hrms.wapi.person.PeopleService;

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
	
	@Autowired
    @Qualifier("hrms.peopleService")
    protected PeopleService peopleService;
	
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
    
    @CrossOrigin
	    @RequestMapping(value = "/headphoto", method = RequestMethod.POST)
	    public void uploadheadphoto(@RequestParam MultipartFile file ,@RequestParam String username ) {
	    	System.out.println(file.getOriginalFilename());
	    	System.out.println(file.getContentType());
	    	System.out.println(username);
	        // ファイルが空の場合は異常終了
	        if(file.isEmpty()){
	            // 異常終了時の処理
	        }
	        //file.upload.photo
	        
	        String path=environment.getProperty("file.upload.photo");
	        try {
		            Path destpath= Paths.get(path+username+".jpg");
		            System.out.println(destpath);
		            Files.copy(file.getInputStream(), destpath, StandardCopyOption.REPLACE_EXISTING);
	        } catch (Exception e) {
	            // 異常終了時の処理
	        	System.out.println(e);
	        } catch (Throwable t) {
	            // 異常終了時の処理
	        }
	    }
    @CrossOrigin
    @RequestMapping(value = "/video", method = RequestMethod.POST)
    public void uploadAppealVideo(@RequestParam MultipartFile file ,@RequestParam String username ) {
    	System.out.println(file.getOriginalFilename());
    	System.out.println(file.getContentType());
    	System.out.println(username);
        // ファイルが空の場合は異常終了
        if(file.isEmpty()){
            // 異常終了時の処理
        }
        
        String path=environment.getProperty("file.upload.video");
        try {
	            Path destpath= Paths.get(path+username+".mp4");
	            System.out.println(destpath);
	            Files.copy(file.getInputStream(), destpath, StandardCopyOption.REPLACE_EXISTING);
	            PeopleBase moveinfo = new PeopleBase();
	            moveinfo.setPerson_id(username);
	            moveinfo.setMoveupldflg("1");
	            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	            moveinfo.setUPDATE_DATE_TIME(timestamp);
	            int count=peopleService.updatemoveinfo(moveinfo);
	            System.out.println(count);
        } catch (Exception e) {
            // 異常終了時の処理
        	System.out.println(e);
        } catch (Throwable t) {
            // 異常終了時の処理
        }
    }

}
