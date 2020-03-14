package hrms.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;

@Data
@Table(name = "T_USER", schema = "${commonSchema}")
public class User extends BaseDataModel {

    private static final long serialVersionUID = 1L;
    /**
     *ユーザーID
     */
    private String userId;
    /**
     * ユーザ名
     */
    private String userName;
    /**
     * パスワード
     */
    private String password;

    private String validFlg;

}