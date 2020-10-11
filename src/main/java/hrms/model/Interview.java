package hrms.model;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;

@Data
@Table(name = "T_B_INTERVIEW", schema = "${hrmsdb01Schema}")
public class Interview extends BaseDataModel {

    private static final long serialVersionUID = 1L;

    private String interviewId;
    
    private String personId;

    private String companyId;

    private String casename;

    private String workplace;

    private String interviewplace;

    private String interviewdate;

    private String starttime;

    private String endtime;

    private String workcontents;

    private String interviewresult;
    
    private String interviewdate1;
    
    private String starttime1;
    
    private String endtime1;
    
    private String interviewdate2;
    
    private String starttime2;
    
    private String endtime2;
    
    private String interviewdate3;
    
    private String starttime3;
    
    private String endtime3;
    
    private String interview_datetime;
    
    private String rateToCompany;
    
    private String messageToCompany;
    
    public String getInterview_datetimeUI() {
    	return interviewdate+ " "+starttime+"～"+endtime;
    	
    }
//    public void setInterview_datetime(String interview_datetime) {
//    	this.interview_datetime=interview_datetime;
//    	
//    }
    public String getInterview_datetime1() {
    	return interviewdate1+ " "+starttime1+"～"+endtime1;
    	
    }
    public String getInterview_datetime2() {
    	return interviewdate2+ " "+starttime2+"～"+endtime2;
    	
    }
    public String getInterview_datetime3() {
    	return interviewdate3+ " "+starttime3+"～"+endtime3;
    	
    }
    public void setinterviewtime() {
    	if(this.getInterview_datetime()!=null&&!"".equals(this.getInterview_datetime())) {
    		this.setInterviewdate(this.getInterview_datetime().substring(0,10));
    		this.setStarttime(this.getInterview_datetime().substring(11,16));
    		this.setEndtime(this.getInterview_datetime().substring(17));
    	}
    	
    }
//    private List interviewtimeList;
//    
//    public void setInterviewtimeList() {
//    	interviewtimeList =new ArrayList<String>();
//    	interviewtimeList.add(interviewdate1+starttime1+endtime1);
//    	interviewtimeList.add(interviewdate2+starttime2+endtime2);
//    	interviewtimeList.add(interviewdate3+starttime3+endtime3);
//    }
    
//    public List getInterviewtimeList() {
//    	return interviewtimeList; 
//    }
    
    

}