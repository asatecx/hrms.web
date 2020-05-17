package hrms.model;

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
    
    private String interview_datetime;

}