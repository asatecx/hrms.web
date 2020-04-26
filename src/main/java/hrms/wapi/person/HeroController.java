package hrms.wapi.person;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.model.Acount;
import hrms.model.City;
import hrms.model.InterviewResult;
import hrms.model.caseobj;

@RestController
@RequestMapping("/niucaocao")
public class HeroController {

	//private HeroService heroService;
	public String useridString;
	/**
     * hero list
     */
   // private  List<Hero> heroes;
   // @Autowired
	// public HeroController(HeroService heroService) {
    public HeroController() {
   
	      // this.heroes = this.heroService.findAll();

	    }
	 

	    
	    //===============================================================================================
    
//    @CrossOrigin
//    @RequestMapping(value = "/main/login",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ApiResponse loginforVue(@ModelAttribute Acount acount) {
//    	System.out.println("userId="+acount.getUserId());
//    	System.out.println("password="+acount.getPassword());
//    	
//    	
//    	  String path = "C:\\Resources\\logindb.txt";
//          File file = new File(path);
//
//          FileOutputStream fileOutputStream;
//		try {
//			fileOutputStream = new FileOutputStream(file);
//	          fileOutputStream.write(acount.getUserId().getBytes());
//
//	          fileOutputStream.close();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e);
//		}
//
//
//        //身份验证是否成功
//        //boolean isSuccess = userService.checkUser(loginName, password);
//    	boolean isSuccess = true;
//        if (isSuccess) {
//           // User user = userService.getUserByLoginName(loginName);
//            //if (user != null) {
//                //返回token
//                //String token = JwtUtil.sign(user.getName(), user.getId());
//            	  String token = JwtUtil.sign( acount.getUserId());
//                if (token != null) {
//                    return ApiResponseUtil.getApiResponse(token);
//                }
//           // }
//        }
//        //返回登陆失败消息
//        return ApiResponseUtil.getApiResponse(ApiResponseEnum.LOGIN_FAIL);
//        
//    }
	    @CrossOrigin
	    @RequestMapping(value = "/makeAcount",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	    public void makeAcount(@ModelAttribute  Acount acount) {
//	        Map<Integer, Hero> heroMap = heroes.streamacount().collect(Collectors.toMap(Hero::getId, Function.identity()));
//	        Hero hero = heroMap.get(id);
//	        return hero;
	    	System.out.println(acount.toString());
	    	//return heroService.findById(id);
	    }
	    

	    @CrossOrigin
	    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	    public void uploadfile(@RequestParam MultipartFile file  ) {
	    	System.out.println(file.getOriginalFilename());
	    	System.out.println(file.getContentType());
	        // ファイルが空の場合は異常終了
	        if(file.isEmpty()){
	            // 異常終了時の処理
	        }
	        try {
	            byte[] bytes = file.getBytes();
	            BufferedOutputStream uploadFileStream =
	                    new BufferedOutputStream(new FileOutputStream("C:\\Resources\\"+file.getOriginalFilename()));
	            uploadFileStream.write(bytes);
	            uploadFileStream.close();
	        } catch (Exception e) {
	            // 異常終了時の処理
	        } catch (Throwable t) {
	            // 異常終了時の処理
	        }
	    	//return heroService.findById(id);
	    }
	    
	    
	    public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	    {
	           File convFile = new File( multipart.getOriginalFilename());
	           multipart.transferTo(convFile);
	           return convFile;
	    }
	    @CrossOrigin
	   // @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
	    @RequestMapping(value = "/headphoto", method = RequestMethod.POST)
	    public void uploadheadphoto(@RequestParam MultipartFile file  ) {
	    	System.out.println(file.getOriginalFilename());
	    	System.out.println(file.getContentType());
	        // ファイルが空の場合は異常終了
	        if(file.isEmpty()){
	            // 異常終了時の処理
	        }
	        try {
	        	;
	            byte[] bytes = file.getBytes();
	            String path = "C:\\Resources\\logindb.txt";
	            
	            FileInputStream fileInputStream = new FileInputStream(path);

	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

	            String line = null;

	            while ((line = bufferedReader.readLine()) != null) {
	                System.out.println(line);
	            
		            BufferedOutputStream uploadFileStream =
		                    new BufferedOutputStream(new FileOutputStream("C:\\Resources\\"+line+".jpg"));
		            File delefile=new File("C:\\Resources\\"+line+".jpg");
		            delefile.delete();
		            uploadFileStream.write(bytes);
		            uploadFileStream.close();
	            }

	            fileInputStream.close();
	        } catch (Exception e) {
	            // 異常終了時の処理
	        	System.out.println(e);
	        } catch (Throwable t) {
	            // 異常終了時の処理
	        }
	    	//return heroService.findById(id);
	    }
	    /**
	     * angular tutorial
	     * reference app/hero-search.service.ts
	     * @param name
	     * @return selected heroes
	     */
	    @CrossOrigin
	    @RequestMapping(value = "/interviewList", method = RequestMethod.GET)
	    public List<InterviewResult> search(@RequestParam   String companyName) {
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
	                .filter(hero -> hero.getCompanyName().toLowerCase().contains(companyName.toLowerCase()))
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

//	        List<Skill> resutlts = skills.stream()
//	                .filter(skill -> skill.getSkillcategory().contains(skillcategory))
//	                .collect(Collectors.toList());
//	        if(resutlts.size()==0) {
//	        	return new ArrayList<Skill>();
//	        }
	        
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
//	        List<caseobj> resutlts = interviewResult.stream()
//	                .filter(caseobj -> caseobj.getId()==id)
//	                .collect(Collectors.toList());
	        return interviewResult;
	    }



}
