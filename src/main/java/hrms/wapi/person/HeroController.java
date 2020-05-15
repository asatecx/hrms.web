package hrms.wapi.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import af.base.model.JsonModel;
import af.base.model.JsonModelTable;
import hrms.model.Carear;
import hrms.model.City;
import hrms.model.InterviewResult;
import hrms.model.PeopleBase;
import hrms.model.PeopleProject;
import hrms.model.PeopleSkill;
import hrms.model.Skill;
import hrms.model.caseobj;

@RestController
@RequestMapping("/niucaocao")
public class HeroController {

	//private HeroService heroService;
	public String useridString;
	
	@Autowired
    @Qualifier("hrms.peopleService")
    protected PeopleService peopleService;

	
    public HeroController() { }

	    @CrossOrigin
	    @RequestMapping(value = "/tanka",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	    public String modifyTankaAndSchedule(@ModelAttribute  PeopleBase tankainfo) {

	    	int count=peopleService.updateTanka(tankainfo);
	    	
	    	if(count>=1) {
	    		return "OK";
	    	}else {
	    		return "NG";
	    	}

	    }
	    
	    @CrossOrigin
	    @RequestMapping(value = "/baseinfo",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	    public String modifyBaseInfo(@ModelAttribute  PeopleBase baseinfo) {

	    	int count=peopleService.updateBaseInfo(baseinfo);
	    	
	    	if(count>=1) {
	    		return "OK";
	    	}else {
	    		return "NG";
	    	}
	    }
	    
	    @CrossOrigin
	    @RequestMapping(value = "/skillinfo")
	    @ResponseBody
	    public String modifySkillInfo(@RequestBody  Skill skillinfo) {
	    	PeopleSkill pSkill=new PeopleSkill();
	    	pSkill.setPerson_id(skillinfo.getTableDataLanguage().get(0).getPerson_id());
	    	int countdelete=peopleService.deleteSkillInfo(pSkill);
	    	boolean count=false;
	    	for (PeopleSkill peopleSkill : skillinfo.getTableDataLanguage()) {
	    		 count=peopleService.updateskillInfo(peopleSkill);
			}
	    	for (PeopleSkill peopleSkill : skillinfo.getTableDataDB()) {
	    		 count=peopleService.updateskillInfo(peopleSkill);
			}
	    	for (PeopleSkill peopleSkill : skillinfo.getTableDataOS()) {
	    		 count=peopleService.updateskillInfo(peopleSkill);
			}
	        return "OK";

	    }
	    
	    @CrossOrigin
	    @RequestMapping(value = "/carearinfo")
	    @ResponseBody
	    public String modifyCarearInfo(@RequestBody  Carear carearinfo) {
	    	PeopleProject pp=new PeopleProject();
	    	pp.setPerson_id(carearinfo.getCarears().get(0).getPerson_id());
	    	peopleService.deleteCarearInfo(pp);
	    	for (PeopleProject carear : carearinfo.getCarears()) {
	    		carear.readyInsert();
	    		 peopleService.updateCarearInfo(carear);
			}

	        return "OK";
	    }
	    
	    /**
	     * angular tutorial
	     * reference app/hero-search.service.ts
	     * @param name
	     * @return selected heroes
	     */
	    @CrossOrigin
	    @RequestMapping(value = "/interviewList", method = RequestMethod.GET)
	    public List<InterviewResult> search(@RequestParam   String casename,
	    		                            @RequestParam   String  userid,
	    		                            @RequestParam   int currentPage,
	    		                            @RequestParam   int pagesize
	    		) {
	      List<InterviewResult> interviewResult =new ArrayList<InterviewResult>();
	      interviewResult.add(new InterviewResult("IBM",
	    		  "2020-10-20 17:00",
	    		  "please wear your suits",
	    		  "yokohama",
	    		  "yokohama Station",
	    		  "ok",
	    		  "you are very good",
	    		  "take your notebook",
	    		  "shinagawa",
	    		  "2020-11-01 9:00"
	    		  ));
	      interviewResult.add(new InterviewResult("SONY",
	    		  "2020-10-21 17:00",
	    		  "please wear your suits",
	    		  "tokyo",
	    		  "tokyo Station",
	    		  "ok",
	    		  "you are very good",
	    		  "take your notebook",
	    		  "tokyo",
	    		  "2020-11-01 9:00"
	    		  ));
	      interviewResult.add(new InterviewResult("NEC",
	    		  "2020-10-20 17:00",
	    		  "please wear your suits",
	    		  "tamachi",
	    		  "tamachi Station",
	    		  "ok",
	    		  "you are very good",
	    		  "take your notebook",
	    		  "tamachi",
	    		  "2020-11-01 9:00"
	    		  ));
	      interviewResult.add(new InterviewResult("NEC",
	    		  "2020-10-20 17:00",
	    		  "please wear your shirt",
	    		  "mukaigawara",
	    		  "mukaigawara Station",
	    		  "ok",
	    		  "you are very good",
	    		  "take your notebook",
	    		  "tamachi",
	    		  "2020-11-01 9:00"
	    		  ));
	        List<InterviewResult> resutlts = interviewResult.stream()
	                .filter(hero -> hero.getCompanyName().toLowerCase().contains(casename.toLowerCase()))
	                .collect(Collectors.toList());
	        return resutlts;
	    }
	    
	    /**
	     * angular tutorial
	     * reference app/hero-search.service.ts
	     * @param name
	     * @return selected heroes
	     */
	    @CrossOrigin
	    @RequestMapping(value = "/gettopTen", method = RequestMethod.GET)
	    public List<caseobj> getcaseobj(@RequestParam   String keyword) {
	      List<caseobj> interviewResult =new ArrayList<caseobj>();
	      interviewResult.add(new caseobj(1,"4月開始、作業場所勝どき<br>日本語１級レベル<br>経験3年<br>java"));
	      interviewResult.add(new caseobj(2,"6月開始、田町<br>日本語１級レベル<br>経験3年<br>java"));
	      interviewResult.add(new caseobj(3,"7月開始、東京<br>日本語１級レベル<br>経験3年<br>.net"));
	      interviewResult.add(new caseobj(4,"8月開始、横浜<br>日本語１級レベル<br>経験3年<br>python"));
	      interviewResult.add(new caseobj(5,"9月開始、多摩川<br>日本語１級レベル<br>経験3年<br>java"));
	      interviewResult.add(new caseobj(6,"10月開始、操他的<br>日本語１級レベル<br>経験3年<br>shell"));
	      interviewResult.add(new caseobj(7,"11月開始、日妹<br>日本語１級レベル<br>経験3年<br>java"));
	      interviewResult.add(new caseobj(8,"12月開始、日姉姉<br>日本語１級レベル<br>経験3年<br>java"));
	        List<caseobj> resutlts = interviewResult.stream()
	                .filter(caseobj -> caseobj.getContent().toLowerCase().contains(keyword))
	                .collect(Collectors.toList());
	        return resutlts;
	    }
	    
	    @CrossOrigin
	    @RequestMapping(value = "/getaddress", method = RequestMethod.GET)
	    public List<String> getcities(@RequestParam   String city) {
	      List<City> cities =new ArrayList<City>();
	      List<String> townStrings=new ArrayList<String>();
	      townStrings.add("小樽市");
	      townStrings.add("旭川市");
	      townStrings.add("室蘭市");
	      townStrings.add("釧路市");
	      townStrings.add("函館市");
	      List<String> townStrings1=new ArrayList<String>();
	      townStrings1.add("横須賀市");
	      townStrings1.add("平塚市");
	      townStrings1.add("茅ヶ崎市");
	      townStrings1.add("大和市");
	      townStrings1.add("海老名市");

	      cities.add(new City("北海道",townStrings));
	      cities.add(new City("神奈川県",townStrings1));

	        List<City> resutlts = cities.stream()
	                .filter(province -> province.getProvince().contains(city))
	                .collect(Collectors.toList());
	        if(resutlts.size()==0) {
	        	return new ArrayList<String>();
	        }
	        return resutlts.get(0).getCity();
	    }
	    @CrossOrigin
	    @RequestMapping(value = "/getskillsource", method = RequestMethod.GET)
	    public Map getskillsource() {
	      List<String> language =new ArrayList<String>();
	      language.add("java");
	      language.add("php");
	      language.add("python");
	      language.add(".net");
	      language.add("plsql");
	      List<String> dbs =new ArrayList<String>();
	      dbs.add("sqlserver");
	      dbs.add("oracle");
	      dbs.add("mysql");
	      
	      List<String> oss =new ArrayList<String>();
	      oss.add("windows");
	      oss.add("linux");
	      oss.add("unix");

	        Map mmMap=new HashMap<String, List>();
	        mmMap.put("language", language);
	        mmMap.put("db", dbs);
	        mmMap.put("os", oss);
	        return mmMap;
	    }
	    @CrossOrigin
	    @RequestMapping(value = "/getCaseDetail", method = RequestMethod.GET)
	    public caseobj getCaseDetail(@RequestParam   int id) {
	      List<caseobj> interviewResult =new ArrayList<caseobj>();
	      interviewResult.add(new caseobj(1,"4月開始、作業場所勝どき<br>日本語１級レベル<br>経験3年<br>java"));
	      interviewResult.add(new caseobj(2,"6月開始、田町<br>日本語１級レベル<br>経験3年<br>java"));
	      interviewResult.add(new caseobj(3,"7月開始、東京<br>日本語１級レベル<br>経験3年<br>.net"));
	      interviewResult.add(new caseobj(4,"8月開始、横浜<br>日本語１級レベル<br>経験3年<br>python"));
	      interviewResult.add(new caseobj(5,"9月開始、多摩川<br>日本語１級レベル<br>経験3年<br>java"));
	      interviewResult.add(new caseobj(6,"10月開始、操他的<br>日本語１級レベル<br>経験3年<br>shell"));
	      interviewResult.add(new caseobj(7,"11月開始、日妹<br>日本語１級レベル<br>経験3年<br>java"));
	      interviewResult.add(new caseobj(8,"12月開始、日姉姉<br>日本語１級レベル<br>経験3年<br>java"));
	        List<caseobj> resutlts = interviewResult.stream()
	                .filter(caseobj -> caseobj.getId()==id)
	                .collect(Collectors.toList());
	        return resutlts.get(0);
	    }
	    @CrossOrigin
	    @RequestMapping(value = "/getCaseList", method = RequestMethod.GET)
	    public List<caseobj> getCaseList(@RequestParam   String keyword) {
	      List<caseobj> interviewResult =new ArrayList<caseobj>();
	      interviewResult.add(new caseobj(1,"4月開始、作業場所勝どき<br>日本語１級レベル<br>経験3年<br>java"
	    		  ,"1大手メディア企業向けシステム開発"
	    		  ,"1営業部隊が使用するシステムの開発運用保守に携わっていただきます。"
	    		  ,"1java開発経験2年以上"
	    		  ,"1要件定義の経験や知見"
	    		  ,"14月～(長期可能)"
	    		  ,"1最寄：東京"));
	      interviewResult.add(new caseobj(2,"6月開始、田町<br>日本語１級レベル<br>経験3年<br>java"
	    		  ,"2大手メディア企業向けシステム開発"
	    		  ,"2営業部隊が使用するシステムの開発運用保守に携わっていただきます。"
	    		  ,"2java開発経験2年以上"
	    		  ,"2要件定義の経験や知見"
	    		  ,"24月～(長期可能)"
	    		  ,"2最寄：東京"));
	      interviewResult.add(new caseobj(3,"7月開始、東京<br>日本語１級レベル<br>経験3年<br>.net"
	    		  ,"3大手メディア企業向けシステム開発"
	    		  ,"3営業部隊が使用するシステムの開発運用保守に携わっていただきます。"
	    		  ,"3java開発経験2年以上"
	    		  ,"3要件定義の経験や知見"
	    		  ,"34月～(長期可能)"
	    		  ,"3最寄：東京"));
	      interviewResult.add(new caseobj(4,"8月開始、横浜<br>日本語１級レベル<br>経験3年<br>python"
	    		  ,"4大手メディア企業向けシステム開発"
	    		  ,"4営業部隊が使用するシステムの開発運用保守に携わっていただきます。"
	    		  ,"4java開発経験2年以上"
	    		  ,"4要件定義の経験や知見"
	    		  ,"44月～(長期可能)"
	    		  ,"4最寄：東京"));
	      interviewResult.add(new caseobj(5,"9月開始、多摩川<br>日本語１級レベル<br>経験3年<br>java"
	    		  ,"5大手メディア企業向けシステム開発"
	    		  ,"5営業部隊が使用するシステムの開発運用保守に携わっていただきます。"
	    		  ,"5java開発経験2年以上"
	    		  ,"5要件定義の経験や知見"
	    		  ,"54月～(長期可能)"
	    		  ,"5最寄：東京"));
	      interviewResult.add(new caseobj(6,"10月開始、操他的<br>日本語１級レベル<br>経験3年<br>shell"
	    		  ,"6大手メディア企業向けシステム開発"
	    		  ,"6営業部隊が使用するシステムの開発運用保守に携わっていただきます。"
	    		  ,"6java開発経験2年以上"
	    		  ,"6要件定義の経験や知見"
	    		  ,"64月～(長期可能)"
	    		  ,"6最寄：東京"));
	      interviewResult.add(new caseobj(7,"11月開始、日妹<br>日本語１級レベル<br>経験3年<br>java"
	    		  ,"7大手メディア企業向けシステム開発"
	    		  ,"7営業部隊が使用するシステムの開発運用保守に携わっていただきます。"
	    		  ,"7java開発経験2年以上"
	    		  ,"7要件定義の経験や知見"
	    		  ,"74月～(長期可能)"
	    		  ,"7最寄：東京"));
	      interviewResult.add(new caseobj(8,"12月開始、日姉姉<br>日本語１級レベル<br>経験3年<br>java"
	    		  ,"8大手メディア企業向けシステム開発"
	    		  ,"8営業部隊が使用するシステムの開発運用保守に携わっていただきます。"
	    		  ,"8java開発経験2年以上"
	    		  ,"8要件定義の経験や知見"
	    		  ,"84月～(長期可能)"
	    		  ,"8最寄：東京"));

	        return interviewResult;
	    }

	    @CrossOrigin
	    @RequestMapping(value = "/gettanka", method = RequestMethod.GET)
	    public PeopleBase gettanka(@RequestParam   String userid) {
	    	PeopleBase user =new PeopleBase();
	         user.setPerson_id(userid);
	         PeopleBase result= peopleService.find(user);
	         return result;
	    }
	    
	    @CrossOrigin
	    @RequestMapping(value = "/getbaseinfo", method = RequestMethod.GET)
	    public PeopleBase getBaseInfo(@RequestParam   String userid) {
	    	PeopleBase user =new PeopleBase();
	         user.setPerson_id(userid);
	         PeopleBase result= peopleService.find(user);
	         return result;
	    }

	    
	    @CrossOrigin
	    @RequestMapping(value = "/getskillinfo", method = RequestMethod.GET)
	    public Skill getSkillInfo(@RequestParam   String userid) {
	    
	         Map<String, Object> param = new HashMap<String, Object>();
	         param.put("PERSON_ID", userid);
	         
	         param.put("SKILLKBN", "LAN");
	         List<PeopleSkill> lanList= peopleService.selectList("hrms.people.selectPeopleSkillList",param,null);
	         param.put("SKILLKBN", "OS");
	         List<PeopleSkill> osList= peopleService.selectList("hrms.people.selectPeopleSkillList",param,null);
	         param.put("SKILLKBN", "DB");
	         List<PeopleSkill> dbList= peopleService.selectList("hrms.people.selectPeopleSkillList",param,null);
	         Skill skills = new Skill();
	         
	         skills.setTableDataLanguage(lanList);
	         skills.setTableDataDB(dbList);
	         skills.setTableDataOS(osList);
	         
	         return skills;
	         // return new JsonModelTable(skillList.size(), skillList);
	    }
	    
	    @CrossOrigin
	    @RequestMapping(value = "/getcarearinfo", method = RequestMethod.GET)
	    public List<PeopleProject> getCarearInfo(@RequestParam   String userid) {
	         Map<String, Object> param = new HashMap<String, Object>();
	         param.put("PERSON_ID", userid);
	         List<PeopleProject> carearList= peopleService.selectList("hrms.people.selectPeopleCarearList",param,null);
	         for (PeopleProject peopleProject : carearList) {
	        	 peopleProject.readyresponse();
			}
	         return carearList;
	    }
	    

}
