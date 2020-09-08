package hrms.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;

@Data
@Table(name = "T_B_CASE", schema = "${commonSchema}")
public class CompanyCase extends BaseDataModel {

    private static final long serialVersionUID = -6904741621609174058L;

    private String userId;
    private int caseId;
    private String caseName;
    private String workcontent;
    private String memo;
    private String validFlg;

}