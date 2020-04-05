package hrms.wapi.resume;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import hrms.model.DevPhase;
import hrms.model.ResumeProject;
import hrms.model.Skill;
import hrms.model.User;

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
        Map<String, Object> data = createData();
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

	private static Map<String,Object> createData(){
		Map<String,Object> root=new HashMap<String,Object>();
		User u1 = new User();
        u1.setUserId("001");
        u1.setValidFlg("1");
        u1.setUserName("Aさん");
        User u2 = new User();
        u2.setUserId("002");
        u2.setUserName("Bさん");
        u2.setValidFlg("2");
        User u3 = new User();
        u3.setUserId("003");
        u3.setUserName("Cさん");
        u3.setValidFlg("3");
        List<User> users = new ArrayList<User>();
        users.add(u1);
        users.add(u2);
        users.add(u3);

        Skill skill1 = new Skill();
        skill1.setSkill("PHP");
        skill1.setPeriod("★4年");
        skill1.setLevel("メンバーに指導ができる");

        Skill skill2 = new Skill();
        skill2.setSkill("Java");
        skill2.setPeriod("★2年");
        skill2.setLevel("業務で即戦力になれる");

        Skill skill3 = new Skill();
        skill3.setSkill("Javascript");
        skill3.setPeriod("★1年");
        skill3.setLevel("業務で即戦力になれる");

        Skill skill4 = new Skill();
        skill4.setSkill("C");
        skill4.setPeriod("学生時代に3年");
        skill4.setLevel("簡単なプログラミングができる");

        Skill skill5 = new Skill();
        skill5.setSkill("Python");
        skill5.setPeriod("自宅にて2年");
        skill5.setLevel("一人でアプリケーション開発ができる");

        List<Skill> programLanguage = new ArrayList<Skill>();
        programLanguage.add(skill1);
        programLanguage.add(skill2);
        programLanguage.add(skill3);
        programLanguage.add(skill4);
        programLanguage.add(skill5);

        Skill skill_db1 = new Skill();
        skill_db1.setSkill("MySQL");
        skill_db1.setPeriod("★4年");
        skill_db1.setLevel("構築からチューニングまで対応できる");

        Skill skill_db2 = new Skill();
        skill_db2.setSkill("Oracle");
        skill_db2.setPeriod("★2年");
        skill_db2.setLevel("SQLを使ったプログラミングができる");

        Skill skill_db3 = new Skill();
        skill_db3.setSkill("PostgresSQL");
        skill_db3.setPeriod("★1年");
        skill_db3.setLevel("知識がある");

        List<Skill> skill_db = new ArrayList<Skill>();
        skill_db.add(skill_db1);
        skill_db.add(skill_db2);
        skill_db.add(skill_db3);

        Skill skill_os1 = new Skill();
        skill_os1.setSkill("Linux");
        skill_os1.setPeriod("★4年");
        skill_os1.setLevel("インストールから簡単な設定ができる");

        Skill skill_os2 = new Skill();
        skill_os2.setSkill("Unix");
        skill_os2.setPeriod("★2年");
        skill_os2.setLevel("簡単なコマンドの入力ができる");
        List<Skill> skill_os = new ArrayList<Skill>();
        skill_os.add(skill_os1);
        skill_os.add(skill_os2);


        DevPhase devPhase = new DevPhase();
        devPhase.setBaseDesign("〇");

        List<ResumeProject> projects = new ArrayList<ResumeProject>();

        ResumeProject project1 = new ResumeProject();
        project1.setNo("1");
        project1.setDevFrom("2015/4/1");
        project1.setDevTo("2016/3/31");
        project1.setWorkplace("日本");
        project1.setProjectName("電力システム開発");
        project1.setProjectType("エネルギー");
        project1.setDevLanguage("Java");
        project1.setDevTool("Eclipse");
        project1.setOS("Windows");
        project1.setDB("Oracle");
        project1.setCharge("SE");
        project1.setDescription("該当会社生産システムを運用監視、通信システム既存システムに従って、機能追加や強化する作業を行う");
        project1.setDevPhase(devPhase);

        ResumeProject project2 = new ResumeProject();
        project2.setNo("2");
        project2.setDevFrom("2018/5/1");
        project2.setDevTo("2020/4/30");
        project2.setWorkplace("日本");
        project2.setProjectName("データ移行システム");
        project2.setProjectType("販売");
        project2.setDevLanguage("Java");
        project2.setDevTool("Eclipse");
        project2.setOS("Linux");
        project2.setDB("MySQL");
        project2.setCharge("PL");
        project2.setDescription("DataSpider ツールを利用し、多種類データベースからOracleへのデータ移行作業を実施する詳細設計～結合テストまで担当する");
        project2.setDevPhase(devPhase);

        projects.add(project1);
        projects.add(project2);

        root.put("programLanguage", programLanguage);
        root.put("skill_db", skill_db);
        root.put("skill_os", skill_os);
        root.put("projects", projects);
		return root;
	}
}