package af.main.model;

import java.util.Date;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Column;
import af.base.orm.annotation.Table;

@Table(name = "T_USER", schema = "${commonSchema}")
public class User extends BaseDataModel {

    private static final long serialVersionUID = -6904741621609174058L;

    private String USER_ID;

    private String USER_PASSWORD;

    @Column(ignore=true)
    private String USER_PASSWORD_CONFIRM;

    private String USER_TYPE;

    private String COMPANY_ID;

    private String DEFAULT_BIZ_ROLE_ID;

    private String USER_DISPLAY_NAME;

    private String USER_NAME_KANA;

    private String USER_NAME_KANJI;

    private String USER_NAME_ROMA;

    private String MAIL;

    private String MOBILE_MAIL;

    private String TELEPHONE_NUMBER;

    private String MOBILE_NUMBER;

    private String FAX_NUMBER;

    private String ZIP_CODE;

    private String ADDRESS;

    private String VALID_FLG;

    private String IP_FREE_FLG;

    private String LOGIN_LOCK_FLG;

    private Date PWD_CHANGE_TIME;

    private String PWD_ERR_DATE_TIME;

    private String PWD_ERR_COUNT;

    private String PWD_HISTORY;

    private String SOKUTO_FLG;

    private String START_DATE;

    private String END_DATE;

    private String USER_CONFIG;

    private String NOTE;

    private String PHOTO_ID;

    private String SECTION_NAME;

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public String getUSER_PASSWORD_CONFIRM() {
        return USER_PASSWORD_CONFIRM;
    }

    public void setUSER_PASSWORD_CONFIRM(String USER_PASSWORD_CONFIRM) {
        this.USER_PASSWORD_CONFIRM = USER_PASSWORD_CONFIRM;
    }

    public String getUSER_TYPE() {
        return USER_TYPE;
    }

    public void setUSER_TYPE(String uSER_TYPE) {
        USER_TYPE = uSER_TYPE;
    }

    public String getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setCOMPANY_ID(String COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    public String getDEFAULT_BIZ_ROLE_ID() {
        return DEFAULT_BIZ_ROLE_ID;
    }

    public void setDEFAULT_BIZ_ROLE_ID(String dEFAULT_BIZ_ROLE_ID) {
        DEFAULT_BIZ_ROLE_ID = dEFAULT_BIZ_ROLE_ID;
    }

    public String getUSER_DISPLAY_NAME() {
        return USER_DISPLAY_NAME;
    }

    public void setUSER_DISPLAY_NAME(String USER_DISPLAY_NAME) {
        this.USER_DISPLAY_NAME = USER_DISPLAY_NAME;
    }

    public String getUSER_NAME_KANA() {
        return USER_NAME_KANA;
    }

    public void setUSER_NAME_KANA(String USER_NAME_KANA) {
        this.USER_NAME_KANA = USER_NAME_KANA;
    }

    public String getUSER_NAME_KANJI() {
        return USER_NAME_KANJI;
    }

    public void setUSER_NAME_KANJI(String USER_NAME_KANJI) {
        this.USER_NAME_KANJI = USER_NAME_KANJI;
    }

    public String getUSER_NAME_ROMA() {
        return USER_NAME_ROMA;
    }

    public void setUSER_NAME_ROMA(String USER_NAME_ROMA) {
        this.USER_NAME_ROMA = USER_NAME_ROMA;
    }

    public String getMAIL() {
        return MAIL;
    }

    public void setMAIL(String MAIL) {
        this.MAIL = MAIL;
    }

    public String getMOBILE_MAIL() {
        return MOBILE_MAIL;
    }

    public void setMOBILE_MAIL(String MOBILE_MAIL) {
        this.MOBILE_MAIL = MOBILE_MAIL;
    }

    public String getTELEPHONE_NUMBER() {
        return TELEPHONE_NUMBER;
    }

    public void setTELEPHONE_NUMBER(String TELEPHONE_NUMBER) {
        this.TELEPHONE_NUMBER = TELEPHONE_NUMBER;
    }

    public String getMOBILE_NUMBER() {
        return MOBILE_NUMBER;
    }

    public void setMOBILE_NUMBER(String MOBILE_NUMBER) {
        this.MOBILE_NUMBER = MOBILE_NUMBER;
    }

    public String getFAX_NUMBER() {
        return FAX_NUMBER;
    }

    public void setFAX_NUMBER(String FAX_NUMBER) {
        this.FAX_NUMBER = FAX_NUMBER;
    }

    public String getZIP_CODE() {
        return ZIP_CODE;
    }

    public void setZIP_CODE(String ZIP_CODE) {
        this.ZIP_CODE = ZIP_CODE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getVALID_FLG() {
        return VALID_FLG;
    }

    public void setVALID_FLG(String VALID_FLG) {
        this.VALID_FLG = VALID_FLG;
    }

    public String getLOGIN_LOCK_FLG() {
        return LOGIN_LOCK_FLG;
    }

    public void setLOGIN_LOCK_FLG(String LOGIN_LOCK_FLG) {
        this.LOGIN_LOCK_FLG = LOGIN_LOCK_FLG;
    }

    public String getIP_FREE_FLG() {
        return IP_FREE_FLG;
    }

    public void setIP_FREE_FLG(String IP_FREE_FLG) {
        this.IP_FREE_FLG = IP_FREE_FLG;
    }

    public String getSTART_DATE() {
        return START_DATE;
    }

    public void setSTART_DATE(String START_DATE) {
        this.START_DATE = START_DATE;
    }

    public String getEND_DATE() {
        return END_DATE;
    }

    public void setEND_DATE(String END_DATE) {
        this.END_DATE = END_DATE;
    }

    public String getUSER_CONFIG() {
        return USER_CONFIG;
    }

    public void setUSER_CONFIG(String USER_CONFIG) {
        this.USER_CONFIG = USER_CONFIG;
    }

    public String getNOTE() {
        return NOTE;
    }

    public void setNOTE(String NOTE) {
        this.NOTE = NOTE;
    }

    public String getPHOTO_ID() {
        return PHOTO_ID;
    }

    public void setPHOTO_ID(String PHOTO_ID) {
        this.PHOTO_ID = PHOTO_ID;
    }

    public String getPWD_ERR_DATE_TIME() {
        return PWD_ERR_DATE_TIME;
    }

    public void setPWD_ERR_DATE_TIME(String pWD_ERR_DATE_TIME) {
        PWD_ERR_DATE_TIME = pWD_ERR_DATE_TIME;
    }

    public String getPWD_ERR_COUNT() {
        return PWD_ERR_COUNT;
    }

    public void setPWD_ERR_COUNT(String pWD_ERR_COUNT) {
        PWD_ERR_COUNT = pWD_ERR_COUNT;
    }

    public String getPWD_HISTORY() {
        return PWD_HISTORY;
    }

    public void setPWD_HISTORY(String pWD_HISTORY) {
        PWD_HISTORY = pWD_HISTORY;
    }

    public String getSOKUTO_FLG() {
        return SOKUTO_FLG;
    }

    public void setSOKUTO_FLG(String sOKUTO_FLG) {
        SOKUTO_FLG = sOKUTO_FLG;
    }

    public Date getPWD_CHANGE_TIME() {
        return PWD_CHANGE_TIME;
    }

    public void setPWD_CHANGE_TIME(Date pWD_CHANGE_TIME) {
        PWD_CHANGE_TIME = pWD_CHANGE_TIME;
    }

    public String getSECTION_NAME() {
        return SECTION_NAME;
    }

    public void setSECTION_NAME(String sECTION_NAME) {
        SECTION_NAME = sECTION_NAME;
    }

}