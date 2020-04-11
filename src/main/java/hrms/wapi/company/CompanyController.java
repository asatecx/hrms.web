package hrms.wapi.company;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import af.base.controller.BaseController;
import af.base.model.JsonModel;
import af.main.model.Login;
import hrms.model.Company;

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
    	login.setUSER_ID(company.getUserId());
    	login.setPASSWORD(company.getPassword());
    	login.setUSER_TYPE("2");
    	login.setVALID_FLG("1");

    	boolean ret = companyService.registCompany(company, login);
    	if (!ret) {
            return new JsonModel(false, "会社重複登録");
        }
        return new JsonModel(true, "会社登録成功。");
    }

}