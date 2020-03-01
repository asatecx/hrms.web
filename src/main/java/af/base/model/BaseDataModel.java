package af.base.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import af.base.model.LoginInfo;
import af.base.orm.annotation.Column;

public class BaseDataModel implements Serializable {

    private static final long serialVersionUID = -1715961500835227529L;

    @Column(canUpdate = false)
    private String CREATE_USER;

    private String UPDATE_USER;

    @Column(canUpdate = false)
    private String CREATED_BY;

    private String UPDATED_BY;

    @Column(canUpdate = false, autoSql = "{sqlserver: 'SYSDATETIME()', mysql: 'now(6)', postgresql: 'current_timestamp', oracle: 'CURRENT_TIMESTAMP(6)'}")
    private Date CREATE_DATE_TIME;

    @Column(isVersion = true, autoSql = "{sqlserver: 'SYSDATETIME()', mysql: 'now(6)', postgresql: 'current_timestamp', oracle: 'CURRENT_TIMESTAMP(6)'}")
    private Timestamp UPDATE_DATE_TIME;

    public String getCREATE_USER() {
        return CREATE_USER;
    }

    public void setCREATE_USER(String CREATE_USER) {
        this.CREATE_USER = CREATE_USER;
    }

    public String getUPDATE_USER() {
        return UPDATE_USER;
    }

    public void setUPDATE_USER(String UPDATE_USER) {
        this.UPDATE_USER = UPDATE_USER;
    }

    public String getCREATED_BY() {
        return CREATED_BY;
    }

    public void setCREATED_BY(String cREATED_BY) {
        CREATED_BY = cREATED_BY;
    }

    public String getUPDATED_BY() {
        return UPDATED_BY;
    }

    public void setUPDATED_BY(String uPDATED_BY) {
        UPDATED_BY = uPDATED_BY;
    }

    public Date getCREATE_DATE_TIME() {
        return CREATE_DATE_TIME;
    }

    public void setCREATE_DATE_TIME(Date CREATE_DATE_TIME) {
        this.CREATE_DATE_TIME = CREATE_DATE_TIME;
    }

    public Date getUPDATE_DATE_TIME2() {
        if (UPDATE_DATE_TIME == null) return null;
        return new Date(UPDATE_DATE_TIME.getTime());
    }

    public Timestamp getUPDATE_DATE_TIME() {
        return UPDATE_DATE_TIME;
    }

    public void setUPDATE_DATE_TIME(Timestamp UPDATE_DATE_TIME) {
        this.UPDATE_DATE_TIME = UPDATE_DATE_TIME;
    }

    public void setBaseInfo(LoginInfo loginInfo, String locale) {
        if (UPDATE_DATE_TIME == null) {
            CREATE_USER = loginInfo.getUserId();
            UPDATE_USER = CREATE_USER;
            CREATED_BY = loginInfo.getActualUserId();
            UPDATED_BY = CREATED_BY;
            CREATE_DATE_TIME = new Date();
            UPDATE_DATE_TIME = new Timestamp(CREATE_DATE_TIME.getTime());
        } else {
            UPDATE_USER = loginInfo.getUserId();
            UPDATED_BY = loginInfo.getActualUserId();
        }
    }
}