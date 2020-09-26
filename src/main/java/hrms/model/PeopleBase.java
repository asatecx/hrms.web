package hrms.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;
@Data
@Table(name = "T_B_PERSON_BASE", schema = "${hrmsdb01Schema}")
public class PeopleBase extends BaseDataModel{

	private String	person_id	;
	private String	user_display_name	;
	private String	user_name_kana	;
	private String	user_name_kanji	;
	private String	user_name_roma	;
	private String	gender	;
	private String	birthday	;
	private String	zip_code	;
	private String	addr_pref	;
	private String	addr_city	;
	private String	station	;
	private String	photo_id	;
	private String	video_id	;
	private String	mail	;
	private String	tel	;
	private String	country	;
	private String	education	;
	private String	major	;
	private String	work_exp	;
	private String	japan_exp	;
	private String	company	;
	private String	contract_type	;
	private String	status	;
	private String	price_min	;
	private String	price_max	;
	private String	schedualstart ;
	private String	schedualend ;
	private String	japaneselevel ;
	private String	graduationdate ;
	private String	exp_pr ;
	private String	name_privacy;
	private String	tel_privacy;
	private String	mail_privacy;
	private String	birthday_privacy;
	private String	company_privacy;
	private String  moveupldflg;

}
