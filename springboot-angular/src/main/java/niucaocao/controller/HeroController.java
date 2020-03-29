package niucaocao.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
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

import niucaocao.ApiResponse;
import niucaocao.ApiResponseEnum;
import niucaocao.ApiResponseUtil;
import niucaocao.JwtUtil;
import niucaocao.domain.Acount;
import niucaocao.domain.Hero;
import niucaocao.domain.InterviewResult;
import niucaocao.domain.caseobj;
import niucaocao.service.HeroService;

@RestController
@RequestMapping("/niucaocao")
public class HeroController {
	@Resource
	private HeroService heroService;
	/**
     * hero list
     */
    private  List<Hero> heroes;
   // @Autowired
	// public HeroController(HeroService heroService) {
    public HeroController() {
   
	      // this.heroes = this.heroService.findAll();

	    }
	 
//	    /**
//	     * angular tutorial
//	     * reference app/hero.service.ts
//	     * @param id
//	     * @return Hero
//	     */
//	    @CrossOrigin
//	    @GetMapping("/{id}")
//	    public Hero getHero(@PathVariable Integer id) {
////	        Map<Integer, Hero> heroMap = heroes.stream().collect(Collectors.toMap(Hero::getId, Function.identity()));
////	        Hero hero = heroMap.get(id);
////	        return hero;
//	    	return heroService.findById(id);
//	    }
//
//	    

//	    
//	    /**
//	     * angular tutorial
//	     *  reference app/hero.service.ts
//	     * @return hero array
//	     */
//	    @CrossOrigin
//	    @GetMapping("/")
//	    public List<Hero> getHeroes() {
//	    	return heroService.findAll();
//	       // return heroes;
//	    }
//	    
//	    /**
//	     * angular tutorial
//	     * reference app/hero.service.ts
//	     * @param newHero
//	     * @return Hero
//	     */
//	    @CrossOrigin
//	    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//	    public Hero create(@RequestBody  Hero hero) {
////	        Optional<Integer> max = heroes.stream().map(hero -> hero.getId()).max(Comparator.naturalOrder());
////	        Integer id = max.get() + 1;
////	        newHero.setId(id);
////	        heroes.add(newHero);
////	        return newHero;
//	    	int count=heroService.save(hero);//因为设定了useGeneratedKeys="true" keyProperty="id" hero已经被set了id
//	    	// count 是更新的件数，id 在 hero.getid里
//	    	return hero;
//	    }
//	    
//	    
	    
	    
	    
	    
	    //===============================================================================================
    
    @CrossOrigin
    @RequestMapping(value = "/main/login",method = RequestMethod.POST)
    public ApiResponse loginforVue(@ModelAttribute String userId,@ModelAttribute String password) {
    	System.out.println(userId);
    	System.out.println(password);
    	
        //身份验证是否成功
        //boolean isSuccess = userService.checkUser(loginName, password);
    	boolean isSuccess = true;
        if (isSuccess) {
           // User user = userService.getUserByLoginName(loginName);
            //if (user != null) {
                //返回token
                //String token = JwtUtil.sign(user.getName(), user.getId());
            	  String token = JwtUtil.sign( userId);
                if (token != null) {
                    return ApiResponseUtil.getApiResponse(token);
                }
           // }
        }
        //返回登陆失败消息
        return ApiResponseUtil.getApiResponse(ApiResponseEnum.LOGIN_FAIL);
        
    }
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
	   // @RequestMapping(value = "/uploadfile",method = RequestMethod.POST)
	    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
	    public void uploadfile(@RequestParam MultipartFile uploadfile  ) {
	    	System.out.println(uploadfile.getOriginalFilename());
	    	System.out.println(uploadfile.getContentType());
	        // ファイルが空の場合は異常終了
	        if(uploadfile.isEmpty()){
	            // 異常終了時の処理
	        }
	        try {
	            byte[] bytes = uploadfile.getBytes();
	            BufferedOutputStream uploadFileStream =
	                    new BufferedOutputStream(new FileOutputStream("C:\\Resources\\"+uploadfile.getOriginalFilename()));
	            uploadFileStream.write(bytes);
	            uploadFileStream.close();
	        } catch (Exception e) {
	            // 異常終了時の処理
	        } catch (Throwable t) {
	            // 異常終了時の処理
	        }
	    	//return heroService.findById(id);
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
//	    private File mkdirs(StringBuffer filePath){
//	        Date now = new Date();
//	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//	        File uploadDir = new File(filePath.toString(), sdf.format(now));
//	        // 既に存在する場合はプレフィックスをつける
//	        int prefix = 0;
//	        while(uploadDir.exists()){
//	            prefix++;
//	            uploadDir =
//	                    new File(filePath.toString() + sdf.format(now) + "-" + String.valueOf(prefix));
//	        }
//
//	        // フォルダ作成
//	        uploadDir.mkdirs();
//
//	        return uploadDir;
//	    }
	    
//	    @CrossOrigin
//	    @GetMapping("/movie")
//	    public List<Hero> getmovie(@RequestParam   String name) {
////	        List<Hero> selectedHeroes = heroes.stream()
////	                .filter(hero -> hero.getName().toLowerCase().contains(name.toLowerCase()))
////	                .collect(Collectors.toList());
////	        return selectedHeroes;
//	    	System.out.println("name----"+name);
//	    	return heroService.findbyInput(name);
//	    	
//	    }
	    
	    
	    //---------------------------------------------------------------------------
//	    @CrossOrigin
//	    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
//	    public void updateHero(@RequestBody  Hero hero) {
//
//	    	heroService.update(hero);
//	    	//return hero;
//	    }
//	    
//	    /**
//	     * angular tutorial
//	     * reference app/hero.service.ts
//	     * @param id
//	     */
//	    @CrossOrigin
//	    @DeleteMapping("/{id}")
//	    public void delete(@PathVariable Integer id) {
//	       // heroes.remove(heroes.stream().filter(hero -> hero.getId() == id).findFirst().get());
//	    	heroService.delete(id);
//	    }
//	    /**
//	     * angular tutorial
//	     * reference app/hero-search.service.ts
//	     * @param name
//	     * @return selected heroes
//	     */
//	    @CrossOrigin
//	    @GetMapping("/niu")
//	    public List<Hero> search(@RequestParam   String name) {
////	        List<Hero> selectedHeroes = heroes.stream()
////	                .filter(hero -> hero.getName().toLowerCase().contains(name.toLowerCase()))
////	                .collect(Collectors.toList());
////	        return selectedHeroes;
//	    	System.out.println("name----"+name);
//	    	return heroService.findbyInput(name);
//	    	
//	    }


}
