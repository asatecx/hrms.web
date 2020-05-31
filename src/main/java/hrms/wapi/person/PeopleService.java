package hrms.wapi.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrms.model.PeopleBase;
import hrms.model.PeopleProject;
import hrms.model.PeopleSkill;
import hrms.wapi.base.HrmsSimpleDaoService;
@Service("hrms.peopleService")
public class PeopleService extends HrmsSimpleDaoService {
	/**
     * 人材情報登録.
     * @param company
     * @return boolean
     */
	@Transactional("hrms.tx")
	public boolean registPeople(PeopleBase baseinfo) {
		int count = super.insert(false, baseinfo);
		if(count>=1) {
			return true;
		}else {
			return false;
		}
	}
	
	@Transactional("hrms.tx")
	public int updateTanka(PeopleBase baseinfo) {
		// 面接情報更新
		return super.updateFree(false, baseinfo,
				new String[] {
						"PRICE_MIN",
						"PRICE_MAX",
						"SCHEDUALSTART",
						"SCHEDUALEND",
						"STATUS"
		                 },
						"PERSON_ID"
						,"UPDATE_DATE_TIME"
						);
	}
	@Transactional("hrms.tx")
	public int updateBaseInfo(PeopleBase baseinfo) {
		// 面接情報更新
		return super.updateFree(false, baseinfo,
				new String[] {
						"PERSON_ID",
					    //"USER_DISPLAY_NAME",
						"USER_NAME_KANA",
						"USER_NAME_KANJI",
						"USER_NAME_ROMA",
						"GENDER",
						"BIRTHDAY",
						"ZIP_CODE",
						"ADDR_PREF",
						"ADDR_CITY",
						"STATION",
						//"PHOTO_ID",
						//"VIDEO_ID",
						"MAIL",
						"TEL",
						"COUNTRY",
						"EDUCATION",
						"MAJOR",
						"WORK_EXP",
						"JAPAN_EXP",
						"COMPANY",
						"CONTRACT_TYPE",
						"STATUS",
						//"PRICE_MIN",
						//"PRICE_MAX",
						"SCHEDUALSTART",
						"SCHEDUALEND",
						"JAPANESELEVEL",
						"GRADUATIONDATE"

		                 },
						"PERSON_ID"
						//,"UPDATE_DATE_TIME"
						);
	}
	
	@Transactional("hrms.tx")
	public int deleteSkillInfo(PeopleSkill skillinfo) {
		// 面接情報更新
		return super.deleteFree(false, skillinfo,
				new String[] {
						"PERSON_ID",
		                 }
				
						);
	}
	@Transactional("hrms.tx")
	public boolean updateskillInfo(PeopleSkill skillinfo) {
		int count = super.insert(false, skillinfo);
		if(count>=1) {
			return true;
		}else {
			return false;
		}
	}
	@Transactional("hrms.tx")
	public boolean updateCarearInfo(PeopleProject carearInfo) {
		int count = super.insert(false, carearInfo);
		if(count>=1) {
			return true;
		}else {
			return false;
		}
	}
	@Transactional("hrms.tx")
	public int deleteCarearInfo(PeopleProject carearInfo) {
		// 面接情報更新
		return super.deleteFree(false, carearInfo,
				new String[] {
						"PERSON_ID",
		                 }
				
						);
	}

}
