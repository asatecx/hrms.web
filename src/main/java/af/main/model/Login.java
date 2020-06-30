package af.main.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;

@Data
@Table(name = "T_B_LOGIN", schema = "${hrmsdb01Schema}")
public class Login extends BaseDataModel {

    private static final long serialVersionUID = 1L;

    private String USERID;

    private String PASSWORD;

    private String USERTYPE;

    private String VALIDFLG;

    private String validateCode;
}