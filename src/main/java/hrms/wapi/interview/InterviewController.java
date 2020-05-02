package hrms.wapi.interview;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//    	ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
//    	ConvertUtils.register(new Converter() {
//            public Object convert(Class type, Object value) {
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.fffffffff");
//                try {
//                    return simpleDateFormat.parse(value.toString());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }
//        }, Date.class);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	SqlTimestampConverter converter = new SqlTimestampConverter(convertTimestamp((String)param.get("UPDATE_DATE_TIME")));
		converter.setPattern("yyyy-MM-dd HH:mm:ss");
		ConvertUtils.register(converter, Timestamp.class);
    	BeanUtils.populate(interview, param);
    	interview.setBaseInfo(interview.getCompanyId(), null);
    	interviewService.updateInterview(interview);
        return new JsonModel(true, "面談予約更新しました。");
    }

    private Date convertDate(String oldDate) {
    	Date date = null;
        try {
        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
            date = sdf.parse(oldDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    private Timestamp convertTimestamp(String oldDate) {
    	Timestamp ts = null;
        try {
        	ts = Timestamp.valueOf(oldDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ts;
    }

}