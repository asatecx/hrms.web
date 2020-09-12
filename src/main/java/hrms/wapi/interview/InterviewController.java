package hrms.wapi.interview;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.SqlTimestampConverter;
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
import af.base.util.DateTimeUtil;
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
    	ConvertUtils.register(new SqlTimestampConverter(null), Timestamp.class);
    	BeanUtils.populate(interview, param);
    	interview.setBaseInfo(interview.getCompanyId(), null);
    	interview.setInterviewresult("1");
    	boolean ret = interviewService.registInterview(interview);
    	if (!ret) {
            return new JsonModel(false, "面談予約失敗しました。");
        }
        return new JsonModel(true, "面談予約成功しました。");
    }

    @RequestMapping(value = "/interview/interviewlist", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel getInterviewList(@RequestBody Map<String, Object> param) throws Exception {
//    	String companyId = (String)param.get("companyId");
    	List<Map<String, Object>> interviewList = interviewService.selectList("hrms.company.selectInterviewList", param, null);
    	return new JsonModelTable(interviewList.size(), interviewList);
    }

    @RequestMapping(value = "/interview/update", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel update(@RequestBody Map<String, Object> param) throws Exception {
    	Interview interview = new Interview();
    	Timestamp ts = DateTimeUtil.parseTimestamp((String)param.get("UPDATE_DATE_TIME"));
    	SqlTimestampConverter converter = new SqlTimestampConverter(ts);
//		converter.setPattern("yyyy-MM-dd HH:mm:ss.SSS");
		ConvertUtils.register(converter, Timestamp.class);
    	BeanUtils.populate(interview, param);
    	interview.setBaseInfo(interview.getCompanyId(), null);
    	interviewService.updateInterview(interview);
        return new JsonModel(true, "面談予約更新しました。");
    }

    @RequestMapping(value = "/interview/updateResult", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel updateResult(@RequestBody Map<String, Object> param) throws Exception {
    	Interview interview = new Interview();
    	Timestamp ts = DateTimeUtil.parseTimestamp((String)param.get("UPDATE_DATE_TIME"));
    	SqlTimestampConverter converter = new SqlTimestampConverter(ts);
    	ConvertUtils.register(converter, Timestamp.class);
    	BeanUtils.populate(interview, param);
    	interview.setBaseInfo(interview.getCompanyId(), null);
    	interviewService.deleteInterview(interview);
        return new JsonModel(true, "面談結果を更新しました。");
    }

    @RequestMapping(value = "/interview/delete", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel detele(@RequestBody Map<String, Object> param) throws Exception {
    	Interview interview = new Interview();
    	Timestamp ts = DateTimeUtil.parseTimestamp((String)param.get("UPDATE_DATE_TIME"));
    	SqlTimestampConverter converter = new SqlTimestampConverter(ts);
    	ConvertUtils.register(converter, Timestamp.class);
    	BeanUtils.populate(interview, param);
    	interview.setBaseInfo(interview.getCompanyId(), null);
    	interviewService.deleteInterview(interview);
        return new JsonModel(true, "面談キャンセルしました。");
    }

    @RequestMapping(value = "/interview/casename", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonModel getCaseName(@RequestBody Map<String, Object> param) throws Exception {
    	List<Map<String, Object>> caseNames = interviewService.selectList("hrms.company.selectCaseName", param, null);
    	return new JsonModelTable(caseNames.size(), caseNames);
    }

//    private Timestamp convertTimestamp(String before) {
//    	Timestamp ts = null;
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+0000");
//        try {
//        	Date after = sdf.parse(before);
//        	after.setTime(after.getTime() + 540*60*1000);
//        	ts = new Timestamp(after.getTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ts;
//    }

//    private Timestamp convertTimestamp(String before) {
//    	Timestamp ts = null;
//        try {
//        	ts = Timestamp.valueOf(before);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ts;
//    }

}