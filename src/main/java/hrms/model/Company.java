package hrms.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;

@Data
@Table(name = "T_B_COMPANY", schema = "${hrmsdb01Schema}")
public class Company extends BaseDataModel {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String userName;

    private String userNameDisp;

    private String tel;

    private String mail;

    private String password;

    private String companyName;

    private String companyURL;

    private String establishYear;

    private String staffNum;

}