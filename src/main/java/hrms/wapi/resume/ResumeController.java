package hrms.wapi.resume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import af.base.controller.BaseController;
import af.base.service.PdfReportService;
import af.base.util.DateUtils;
import hrms.model.PeopleBase;
import hrms.model.ResumeProject;
import hrms.wapi.person.PeopleService;

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

	@Autowired
    @Qualifier("hrms.peopleService")
    protected PeopleService peopleService;

	@Autowired
    @Qualifier("hrms.resumeService")
    protected ResumeService resumeService;

    @RequestMapping(value = "/resume", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public void showPdf(@RequestBody Map<String, Object> param, HttpServletResponse response) throws IOException {
        //職歴のデータ
        Map<String, Object> data = createData(param);
        String dest = pdfReportService.exportToFile(data, "resume.ftl", "simhei.ttf");
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

	private Map<String,Object> createData(Map<String,Object> param){
		Map<String,Object> resume = new HashMap<String,Object>();
		// 個人基本情報
		PeopleBase user = new PeopleBase();
		user.setPerson_id(String.valueOf(param.get("PERSON_ID")));
		PeopleBase resumeBase = peopleService.find(user);

		String gender = "1".equals(resumeBase.getGender())? "男" : "女";
		resumeBase.setGender(gender);
		resumeBase.setAge(String.valueOf(DateUtils.getAge(resumeBase.getBirthday())));

		Map<String, Object> skillMap = resumeService.selectSkills(param);

        List<ResumeProject> projects = resumeService.selectProjectList(param);

        resume.put("resumeBase", resumeBase);
        resume.put("programLanguage", skillMap.get("lan"));
        resume.put("skill_db", skillMap.get("db"));
        resume.put("skill_os", skillMap.get("os"));
        resume.put("projects", projects);
		return resume;
	}
}