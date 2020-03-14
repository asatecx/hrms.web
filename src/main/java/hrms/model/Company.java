package hrms.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;

@Data
@Table(name = "T_COMPANY", schema = "${commonSchema}")
public class Company extends BaseDataModel {

    private static final long serialVersionUID = 1L;

    private String COMPANY_ID;

    private String COMPANY_NAME;

}