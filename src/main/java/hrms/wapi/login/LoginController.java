package hrms.wapi.login;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import af.base.controller.BaseController;
import af.base.model.ClientInformation;
import af.base.model.JsonModel;
import af.base.orm.annotation.ClientDetail;
import af.base.util.InputCheckUtil;
import hrms.model.Constants;
import hrms.model.PeopleBase;
import hrms.wapi.person.PeopleService;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.hrms.wapi.login<br/>
 * Class         LoginController<br/>
 * Summary       ログイン<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/03/14       tang-xf      Add          1.0.0      新規作成<br/>
 ************************************************************************/
@Scope("request")
@RestController
public class LoginController extends BaseController {
    @Autowired
	private LoginService loginService;

	@Autowired
    @Qualifier("hrms.peopleService")
    protected PeopleService peopleService;
    /**
     * Search login list.
     * @param map パラメーター
     * @param client ClientInformation
     * @return login list JsonModel
     */
    @RequestMapping(value = "/main/login", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel login(@RequestBody Map<String, String> map, @ClientDetail ClientInformation client) {
        String rules = "{\r\n" +
                    "      userId : {\r\n" +
                    "        required : true\r\n" +
                    "      },\r\n" +
                    "      password : {\r\n" +
                    "        required : true\r\n" +
                    "      }\r\n" +
                    "    }";
        Map<Integer, Map<String, List<String>>> errs = InputCheckUtil.checkAll(map, rules, null);
        if (!errs.isEmpty()) {
            return new JsonModel(false, this.getMessage("main.inputCheck.error"), errs);
        }

        String userId = map.get("userId");
        String password = map.get("password");

        // ユーザー情報取得
        hrms.model.Login user = loginService.getUser(userId);
        if (user == null) {
            return new JsonModel(false, this.getMessage("main.login.error.mailPwd"));
        }
        // アカウント有効性チェック
        if (!Constants.VALID_FLG_TRUE.equals(user.getValidFlg())) {
            return new JsonModel(false, this.getMessage("アカウント認証されていません。"));
        }
        // vパスワードチェック
//      if (!StringUtil.digestMessage(password, userId).equals(user.getUSER_PASSWORD())) {
        if (!password.equals(user.getPassword())) {
            // ログイン失敗履歴追加
//            this.loginService.recordLoginFail(userId,client.getClientID(), client.getClientIP());

            return new JsonModel(false, this.getMessage("main.login.error.mailPwd"));
        }

        // その他情報取得
//        Company company = loginService.getCompany(user.getCOMPANY_ID());
//        if (company == null) {
//            logger.info("Failed to login. Invalid company id: " + user.getCOMPANY_ID());
//            return new JsonModel(false, this.getMessage("main.login.error.mailPwd"));
//        }
//
//        String ip = request.getRemoteAddr();
//        boolean ok = this.loginService.isInIpRange(ip, user.getCOMPANY_ID(), userId);
//        if (!ok) {
//            logger.info("Failed to login. Invalid company id: " + user.getCOMPANY_ID());
//            return new JsonModel(false, this.getMessage("main.login.error.ipOutRange"));
//        }

        // ログイン成功履歴追加
//        this.loginService.recordLoginSuccess(userId,client.getClientID(), client.getClientIP(), "PASSWORD");

//        List<Section> sections = loginService.getSectionList(userId);
//        List<BizRole> roles = loginService.getBizRoleList(userId);
//        List<String> roleIds = new ArrayList<>();
//        roles.forEach(r -> roleIds.add(Constants.COMPANY_COMMOM.equals(r.getCOMPANY_ID()) ? Constants.COMPANY_COMMOM + r.getBIZ_ROLE_ID() : r.getBIZ_ROLE_ID()));

        Map<String, Object> dtDetail = new HashMap<String, Object>();
        if("1".equals(user.getUserType())) {
        	dtDetail.put("userId", user.getUserId());
        }else {
        	dtDetail.put("companyId", user.getUserId());
        }
        dtDetail.put("userType", user.getUserType());
//        dtDetail.put("userId", user.getUSER_ID());
//        dtDetail.put("ActualCompanyID", company.getCOMPANY_ID());
//        dtDetail.put("UserID", user.getUSER_ID());
//        dtDetail.put("UserType", user.getUSER_TYPE());
//        dtDetail.put("BizType", company.getBUSINESS_TYPE());
//        dtDetail.put("Company", company);
//        dtDetail.put("CompanyId", user.getCOMPANY_ID());
//        dtDetail.put("Mail", user.getMAIL());
//        dtDetail.put("RoleIDs", roleIds);
//        dtDetail.put("Roles", roles);
//        dtDetail.put("Sections", sections);
//        dtDetail.put("UserName", user.getUSER_DISPLAY_NAME());

//        List<FuncRoleItem> funcRoleItems = loginService.getFunRoleList(userId);
//
//        PFAuthData pfAuth = new PFAuthData();
//        pfAuth.setActualUserId(user.getUSER_ID());
//        pfAuth.setUserId(user.getUSER_ID());
//        pfAuth.setCompanyId(user.getCOMPANY_ID());
//        pfAuth.setAccountSwitchPrimaryBizRoleId(null);
//        pfAuth.setClientID(client.getClientID());
//        PFAuthenticationToken token = new PFAuthenticationToken(new LoginInfo(user.getUSER_ID(), user, roles, null, funcRoleItems, company, sections), pfAuth);
//        SecurityContextHolder.getContext().setAuthentication(token);
//
//        dtDetail.put("AccountSwitchPrimaryBizRole", null);

        Map<String, Object> dt = new HashMap<String, Object>();
        dt.put("res", "OK");
        dt.put("detail", dtDetail);

        return new JsonModel(true, "OK", dt);
    }

    @CrossOrigin
    @RequestMapping(value = "/main/makeAcount",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel makeAcount(@ModelAttribute  hrms.model.Login userinfo) {
        Map<String, Object> dtDetail = new HashMap<String, Object>();
    	 boolean result=loginService.insertLoginUser(userinfo);
    	 PeopleBase mbaseinfo = new PeopleBase();
    	 if("1".equals(userinfo.getUserType())) {

    		 mbaseinfo.setPerson_id(userinfo.getUserId());
    		// mbaseinfo.set(userinfo.getUserType());
    		 mbaseinfo.setMail(userinfo.getEmail());
	    	 boolean peopleResult=peopleService.registPeople(mbaseinfo);

	    	 if(result&&peopleResult) {
	    		 dtDetail.put("userId", userinfo.getUserId());
	    	 }else {
	    		 return new JsonModel("NG");
	    	 }

    	 }else {
    		 //xiao fan write the logic of company  here please!!!!!!!!!!
          	dtDetail.put("companyId", userinfo.getUserId());
          }

         dtDetail.put("userType", userinfo.getUserType());

         Map<String, Object> dt = new HashMap<String, Object>();
         dt.put("res", "OK");
         dt.put("detail", dtDetail);

         return new JsonModel(dt);


    }

}
