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

    private String interviewdate1;

    private String starttime1;

    private String endtime1;

    private String interviewdate2;

    private String starttime2;

    private String endtime2;

    private String interviewdate3;

    private String starttime3;

    private String endtime3;

    private String workcontents;

    private String interviewresult;

    private String interview_datetime;

}