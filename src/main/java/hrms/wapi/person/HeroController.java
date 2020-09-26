package hrms.wapi.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.aspectj.weaver.ast.And;
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

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import af.base.model.JsonModel;
import hrms.model.Carear;
import hrms.model.City;
import hrms.model.Interview;
import hrms.model.Interviews;
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
	private  double weight;
	@Autowired
    @Qualifier("hrms.peopleService")
    protected PeopleService peopleService;

	
    public HeroController() { }

	    @CrossOrigin
	    @RequestMapping(value = "/tanka",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	    public String modifyTankaAndSchedule(@ModelAttribute  PeopleBase tankainfo) {
	    	System.out.println(tankainfo.getUPDATE_DATE_TIME());
	    	int count=peopleService.updateTanka(tankainfo);
	    	
	    	
	    	if(count>=1) {
	    		return "OK";
	    	}else {
	    		return "NG";
	    	}

	    }
	    
//	    @CrossOrigin
//	    @RequestMapping(value = "/moveflg",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//	    public String modifymoveinfo(@ModelAttribute  PeopleBase moveinfo) {
//	    	System.out.println(moveinfo.getMoveupldflg());
//	    	int count=peopleService.updatemoveinfo(moveinfo);
//	    	if(count>=1) {
//	    		return "OK";
//	    	}else {
//	    		return "NG";
//	    	}
//
//	    }
	    
	    
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
	    @RequestMapping(value = "/baseinfoP",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	    public String modifyBaseInfoP(@ModelAttribute  PeopleBase baseinfo) {

	    	int count=peopleService.updatePersonal(baseinfo);
	    	
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
	    public List<Interview> getInterviewList(@RequestParam   String casename,
	    									@RequestParam   String casetime,
	    									@RequestParam   String caseplace,
	    									@RequestParam   String result,
	    		                            @RequestParam   String  userid,
	    		                            @RequestParam   int currentPage,
	    		                            @RequestParam   int pagesize
	    		) {
	    	if("".equals(casename))casename=null;
	    	if("".equals(casetime))casetime=null;
	    	if("".equals(caseplace))caseplace=null;
	    	if("".equals(result))result=null;
	     
	         Map<String, Object> param = new HashMap<String, Object>();
	         param.put("personId", userid);
	         param.put("casename", casename);
	         param.put("casetime", casetime);
	         param.put("caseplace", caseplace);
	         param.put("result", result);
	         param.put("mylimit", pagesize);
	         param.put("myoffset", pagesize*(currentPage-1));
	         List<Interview> interviewList= peopleService.selectList("hrms.people.selectInterviewList",param,null);

	         return interviewList;
	    }
	    
	    @CrossOrigin
	    @RequestMapping(value = "/deleteInterview", method = RequestMethod.GET)
	    public int deleteInterview(@RequestParam   String interviewId,
	    		                            @RequestParam   String  userid
	    		                    
	    		) {
	     
	    	Interview interview =new Interview();
	    	
	    	interview.setInterviewId(interviewId);
	    	interview.setPersonId(userid);
	         int number= peopleService.deleteFree(false, interview, new String[]{"INTERVIEW_ID","PERSON_ID"});

	         return number;
	    }
	    
	    

	    @CrossOrigin
	    @RequestMapping(value = "/deleteInterviews")
	    @ResponseBody
	    public int[] deleteInterviews(@RequestBody   Interviews interviews
	    		
	    		                    
	    		) {
	     
	         int[] number= peopleService.deleteFree(false, interviews.getInterviews(), new String[]{"INTERVIEW_ID","PERSON_ID"});

	         return number;
	    }
	    /**
	     * angular tutorial
	     * reference app/hero-search.service.ts
	     * @param name
	     * @return selected heroes
	     */
	    @CrossOrigin
	    @RequestMapping(value = "/interviewNumber", method = RequestMethod.GET)
	    public JsonModel getInterviewNumber(@RequestParam   String casename,
	    		                            @RequestParam   String  userid
	    		                      
	    		) {
	     
	         Map<String, Object> param = new HashMap<String, Object>();
	         param.put("personId", userid);
	
	       Map<String, Object> number= peopleService.selectOne("hrms.people.selectInterviewNum",param,null);

	       return new JsonModel( number);
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
	    	
	    	 Map<String, Object> param = new HashMap<String, Object>();
	         param.put("Prefecture", city);
	         List<String> cities= peopleService.selectList("hrms.people.selectcities",param,null);

	        return cities;
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
	    @RequestMapping(value = "/getskillsource", method = RequestMethod.GET)
	    public Map getskillsource() {
	    	
	    	 Map<String, Object> param = new HashMap<String, Object>();
	         param.put("type", 1);
	         List<String> language= peopleService.selectList("hrms.people.selectskills",param,null);
	         
	         param.put("type", 2);
	         List<String> dbs= peopleService.selectList("hrms.people.selectskills",param,null);
	         
	         param.put("type", 3);
	         List<String> oss= peopleService.selectList("hrms.people.selectskills",param,null);

	        Map mmMap=new HashMap<String, List>();
	        mmMap.put("language", language);
	        mmMap.put("db", dbs);
	        mmMap.put("os", oss);
	        return mmMap;
	    }
	    @CrossOrigin
	    @RequestMapping(value = "/getskillsourceNoKBN", method = RequestMethod.GET)
	    public Map getskillsourceNoKBN() {
	    	
	    	 Map<String, Object> param = new HashMap<String, Object>();
	         param.put("type", 1);
	         List<String> language= peopleService.selectList("hrms.people.selectskills",param,null);
	         
	         param.put("type", 2);
	         List<String> dbs= peopleService.selectList("hrms.people.selectskills",param,null);
	         
	         param.put("type", 3);
	         List<String> oss= peopleService.selectList("hrms.people.selectskills",param,null);
	         List<String> resultList=new ArrayList<String>();
	         resultList.addAll(language);
	         resultList.addAll(dbs);
	         resultList.addAll(oss);
	        Map mmMap=new HashMap<String, List>();
	        mmMap.put("skills", resultList);
	        return mmMap;
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
	    @CrossOrigin
	    @RequestMapping(value = "/getkanseidoinfo", method = RequestMethod.GET)
	    public int  getcompletepercent(@RequestParam   String userid) {
	         Map<String, Object> param = new HashMap<String, Object>();
	         weight=0;
	       
	         param.put("PERSON_ID", userid);
	   
	         
	         param.put("SKILLKBN", "LAN");
	         List<PeopleSkill> lanList= peopleService.selectList("hrms.people.selectPeopleSkillList",param,null);
	         param.put("SKILLKBN", "OS");
	         List<PeopleSkill> osList= peopleService.selectList("hrms.people.selectPeopleSkillList",param,null);
	         param.put("SKILLKBN", "DB");
	         List<PeopleSkill> dbList= peopleService.selectList("hrms.people.selectPeopleSkillList",param,null);
	        
	         if(lanList.size()>0) {
	        	 weight++;
	         }
	         if(lanList.size()>0) {
	        	 weight++;
	         }
	         if(dbList.size()>0) {
	        	 weight++;
	         }
     
	         param.put("PERSON_ID", userid);
	         List<PeopleProject> carearList= peopleService.selectList("hrms.people.selectPeopleCarearList",param,null);
	         if(carearList.size()>0) {
	        	 weight++;
	         }
	       	 PeopleBase user =new PeopleBase();
	         user.setPerson_id(userid);
	         PeopleBase result= peopleService.find(user);
	         if(result.getUser_name_roma()!=null) {
	        	 weight++;
	         }
	         if(result.getPrice_max()!=null && result.getPrice_min()!=null) {
	        	 weight++;
	         }
	         if("1".equals(result.getMoveupldflg())) {
	        	 weight++;
	         }
	         
	        return (int)((weight/7)*100);
	    }

}
