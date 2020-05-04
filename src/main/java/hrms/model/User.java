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
     * パスワード
     */
    private String password;
    
    private String userType;
    /**
     * メール
     */
    private String mail;


    private String validFlg;

}