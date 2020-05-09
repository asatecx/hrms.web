package hrms.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;
@Data
@Table(name = "T_B_PERSON_BASE", schema = "${hrmsdb01Schema}")
public class PeopleBase extends BaseDataModel{

	private String	PERSON_ID	;
	private String	USER_DISPLAY_NAME	;
	private String	USER_NAME_KANA	;
	private String	USER_NAME_KANJI	;
	private String	USER_NAME_ROMA	;
	private String	GENDER	;
	private String	BIRTHDAY	;
	private String	ZIP_CODE	;
	private String	ADDR_PREF	;
	private String	ADDR_CITY	;
	private String	STATION	;
	private String	PHOTO_ID	;
	private String	VIDEO_ID	;
	private String	MAIL	;
	private String	TEL	;
	private String	COUNTRY	;
	private String	EDUCATION	;
	private String	MAJOR	;
	private String	WORK_EXP	;
	private String	JAPAN_EXP	;
	private String	COMPANY	;
	private String	CONTRACT_TYPE	;
	private String	STATUS	;
	private String	PRICE_MIN	;
	private String	PRICE_MAX	;
	private String	SCHEDUALSTART ;
	private String	SCHEDUALEND ;
	private String	JAPANESELEVEL ;
	private String	GRADUATIONDATE ;

}
