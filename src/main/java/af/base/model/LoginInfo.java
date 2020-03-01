package af.base.model;

import af.main.model.User;

/*************************************************************************
 * Copyright       Asatecx Co.,Ltd.<br/>
 * Package         af.base.model<br/>
 * Class           LoginInfo<br/>
 * Summary         ログイン情報<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/02/29       tang        Add          1.0.0       新規作成<br/>
 ************************************************************************/
public class LoginInfo {

    private static final long serialVersionUID = -4200676378331496432L;

    protected String actualUserId;

    protected User user;

    /**
     * ユーザ情報取得.
     * @return ユーザ情報
     */
    public User getUser() {
        return user;
    }

    /**
     * ユーザID取得.
     * @return ユーザID
     */
    public String getUserId() {
        return user.getUSER_ID();
    }

    /**
     * 実際ユーザID取得.
     * @return ユーザID
     */
    public String getActualUserId() {
        return actualUserId != null ? actualUserId : getUserId();
    }
 }
