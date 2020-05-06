package hrms.wapi.person;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import af.base.controller.BaseController;
import af.base.model.JsonModel;
import af.base.model.JsonModelTable;

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
public class PersonController extends BaseController  {
	@Autowired
    @Qualifier("hrms.personService")
    protected PersonService personService;

    @RequestMapping(value = "/person/list", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel getPersonList(@RequestBody Map<String, Object> param) throws Exception {
    	List<Map<String,Object>> personList = personService.selectPersonList(param);
    	return new JsonModelTable(personList.size(), personList);
    }

    @RequestMapping(value = "/person/detail", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel getPersonDetail(@RequestBody Map<String, String> param) throws Exception {
    	Map<String,Object> personDetail = personService.selectPersonDetail(param);
    	if(personDetail == null) {
    		return new JsonModelTable(0, personDetail);
    	}
    	return new JsonModelTable(1, personDetail);
    }

}