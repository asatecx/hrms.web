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
import hrms.model.ResumeBase;
import hrms.model.ResumeProject;

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
		ResumeBase resumeBase = new ResumeBase();
		resumeBase.setNameKj(String.valueOf(param.get("USER_NAME_KANJI")));
		resumeBase.setNameKn(String.valueOf(param.get("USER_NAME_KANA")));
		resumeBase.setGender(String.valueOf(param.get("GENDER")));
		resumeBase.setBirthday(String.valueOf(param.get("BIRTHDAY")));
		int age = DateUtils.getAge(String.valueOf(param.get("BIRTHDAY")));
		resumeBase.setAge(String.valueOf(age));
		resumeBase.setJpLevel(String.valueOf(param.get("JAPANESELEVEL")));
		resumeBase.setCountry(String.valueOf(param.get("COUNTRY")));
		resumeBase.setStation(String.valueOf(param.get("STATION")));
		resumeBase.setEducation(String.valueOf(param.get("EDUCATION")));
		resumeBase.setMajor(String.valueOf(param.get("MAJOR")));
		resumeBase.setGraduation(String.valueOf(param.get("GRADUATIONDATE")));
		resumeBase.setJapanYears(String.valueOf(param.get("JAPAN_EXP")));
		resumeBase.setWorkYears(String.valueOf(param.get("WORK_EXP")));

		Map<String, Object> skillMap = resumeService.selectSkills(param);

        List<ResumeProject> projects = resumeService.selectProjectList(param);

//        ResumeProject project1 = new ResumeProject();
//        project1.setNo("1");
//        project1.setDevFrom("2015/4/1");
//        project1.setDevTo("2016/3/31");
//        project1.setWorkplace("日本");
//        project1.setProjectName("電力システム開発");
//        project1.setProjectType("エネルギー");
//        project1.setDevLanguage("Java");
//        project1.setDevTool("Eclipse");
//        project1.setOS("Windows");
//        project1.setDB("Oracle");
//        project1.setCharge("SE");
//        project1.setDescription("該当会社生産システムを運用監視、通信システム既存システムに従って、機能追加や強化する作業を行う");
//        project1.setDevPhase(devPhase);
//
//        ResumeProject project2 = new ResumeProject();
//        project2.setNo("2");
//        project2.setDevFrom("2018/5/1");
//        project2.setDevTo("2020/4/30");
//        project2.setWorkplace("日本");
//        project2.setProjectName("データ移行システム");
//        project2.setProjectType("販売");
//        project2.setDevLanguage("Java");
//        project2.setDevTool("Eclipse");
//        project2.setOS("Linux");
//        project2.setDB("MySQL");
//        project2.setCharge("PL");
//        project2.setDescription("DataSpider ツールを利用し、多種類データベースからOracleへのデータ移行作業を実施する詳細設計～結合テストまで担当する");
//        project2.setDevPhase(devPhase);
//
//        projects.add(project1);
//        projects.add(project2);

        resume.put("resumeBase", resumeBase);
        resume.put("programLanguage", skillMap.get("lan"));
        resume.put("skill_db", skillMap.get("db"));
        resume.put("skill_os", skillMap.get("os"));
        resume.put("projects", projects);
		return resume;
	}
}