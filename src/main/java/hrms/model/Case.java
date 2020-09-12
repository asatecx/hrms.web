package hrms.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;

@Data
@Table(name = "T_B_CASE", schema = "${commonSchema}")
public class Case extends BaseDataModel {

    private static final long serialVersionUID = -6904741621609174058L;

    private String userId;
    private int seq;
    private String casename;
    private String workplace;
    private String workcontent;
    private String startdate;
    private String enddate;
    private String memo;
    private String validFlg;

}