package hrms.wapi.interview;

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
import hrms.model.Interview;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.hrms.wapi.interview<br/>
 * Class         InterviewController<br/>
 * Summary       面談<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/04/25       tang-xf      Add          1.0.0      新規作成<br/>
 ************************************************************************/
@RestController
public class InterviewController extends BaseController  {
	@Autowired
    @Qualifier("hrms.interviewService")
    protected InterviewService interviewService;

    @RequestMapping(value = "/interview/regist", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel regist(@RequestBody Map<String, Object> param) throws Exception {

    	Interview interview = new Interview();
    	BeanUtils.populate(interview, param);
    	boolean ret = interviewService.registInterview(interview);
    	if (!ret) {
            return new JsonModel(false, "面談予約失敗しました。");
        }
        return new JsonModel(true, "面談予約成功しました。");
    }

}