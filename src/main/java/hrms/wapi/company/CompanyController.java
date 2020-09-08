package hrms.wapi.company;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import af.base.controller.BaseController;
import af.base.model.JsonModel;
import hrms.model.Company;
import hrms.model.CompanyCase;
import hrms.model.Login;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.hrms.wapi.company<br/>
 * Class         CompanyController<br/>
 * Summary       ログイン<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/04/08       tang-xf      Add          1.0.0      新規作成<br/>
 ************************************************************************/
@RestController
public class CompanyController extends BaseController  {
	@Autowired
    @Qualifier("hrms.companyService")
    protected CompanyService companyService;

    @RequestMapping(value = "/company/regist", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel regist(@RequestBody Map<String, Object> param) throws Exception {
    	Company company = new Company();
    	BeanUtils.populate(company, param);
    	company.setUserId(company.getMail());

    	Login login = new Login();
    	login.setUserId(company.getUserId());
    	login.setPassword(company.getPassword());
    	login.setUserType("2");
    	login.setValidFlg("0");

    	boolean ret = companyService.registCompany(company, login);
    	if (!ret) {
            return new JsonModel(false, "会社重複登録");
        }
        return new JsonModel(true, "会社登録成功。");
    }

    @RequestMapping(value = "/company/activate/{mailaddr}/{validateCode}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel activate(@PathVariable String mailaddr, @PathVariable String validateCode) throws Exception {

    	Login login = new Login();
    	login.setUserId(mailaddr);
    	login.setValidFlg("1");

    	boolean ret = companyService.activateCompany(login, validateCode);
    	if (!ret) {
            return new JsonModel(false, "認証情報が間違いました。も一回確認お願いいたします。");
        }
        return new JsonModel(true, "認証しました。");
}
    @RequestMapping(value = "/company/case/regist", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel registCase(@RequestBody Map<String, Object> param) throws Exception {
    	CompanyCase companyCase = new CompanyCase();
    	BeanUtils.populate(companyCase, param);
    	companyCase.setValidFlg("1");
    	boolean ret = companyService.registCase(companyCase);
    	if (!ret) {
            return new JsonModel(false, "案件重複登録。");
        }
        return new JsonModel(true, "案件登録成功。");
    }

}