package hrms.wapi.casemng;

import java.util.List;
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
import af.base.model.JsonModelTable;
import hrms.model.Case;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.hrms.wapi.casemng<br/>
 * Class         CaseController<br/>
 * Summary       案件管理<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/09/12       tang-xf      Add          1.0.0      新規作成<br/>
 ************************************************************************/
@RestController
public class CaseController extends BaseController  {
	@Autowired
    @Qualifier("hrms.caseService")
    protected CaseService caseService;

    @RequestMapping(value = "/case/regist", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel registCase(@RequestBody Map<String, Object> param) throws Exception {
    	Case companyCase = new Case();
    	BeanUtils.populate(companyCase, param);
    	companyCase.setValidFlg("1");
    	boolean ret = caseService.registCase(companyCase);
    	if (!ret) {
            return new JsonModel(false, "案件重複登録。");
        }
        return new JsonModel(true, "案件登録成功。");
    }

    @RequestMapping(value = "/case/caselist", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel getInterviewList(@RequestBody Map<String, Object> param) throws Exception {
    	List<Map<String, Object>> caseList = caseService.selectList("hrms.case.selectCaseList", param, null);
    	return new JsonModelTable(caseList.size(), caseList);
    }

}