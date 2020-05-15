package hrms.wapi.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrms.model.PeopleSkill;
import hrms.model.ResumeProject;
import hrms.wapi.base.HrmsSimpleDaoService;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.main.wapi.resume<br/>
 * Class         ResumeService<br/>
 * Summary       職歴サービス<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/05/06       tang-xf     Add          1.0.0       新規作成<br/>
 ************************************************************************/
@Service("hrms.resumeService")
public class ResumeService extends HrmsSimpleDaoService {

	/**
     * 個人技術検索.
     * @param company
     * @return boolean
     */
	@Transactional("hrms.tx")
	public Map<String, Object> selectSkills(Map<String, Object> param) {
		Map<String, Object> skillMap = new HashMap<String, Object>();
		List<PeopleSkill> langList = new ArrayList<PeopleSkill>();
		List<PeopleSkill> dbList = new ArrayList<PeopleSkill>();
		List<PeopleSkill> osList = new ArrayList<PeopleSkill>();
		param.put("personId", param.get("PERSON_ID"));
		List<Map<String, Object>> skills = baseDao.selectList("hrms.resume.selectSkills", param, null);
		for(Map<String, Object> map : skills) {
			PeopleSkill skill = new PeopleSkill();
			skill.setSkill(String.valueOf(map.get("SKILL")));
			skill.setExp(String.valueOf(map.get("EXP")));
			skill.setLevelContent(getLevelVal(String.valueOf(map.get("LEVEL")), String.valueOf(map.get("SKILLKBN"))));
			if("LAN".equals(map.get("SKILLKBN"))) {
				langList.add(skill);
			}else if("DB".equals(map.get("SKILLKBN"))) {
				dbList.add(skill);
			}else if("OS".equals(map.get("SKILLKBN"))) {
				osList.add(skill);
			}
		}
		skillMap.put("lan", langList);
		skillMap.put("db", dbList);
		skillMap.put("os", osList);
		return skillMap;
	}

	/**
     * 人材案件履歴検索.
     * @param personId
     * @return Map<String, Object>
     */
	@Transactional("hrms.tx")
	public List<ResumeProject> selectProjectList(Map<String, Object> param) {
		List<ResumeProject> projects = new ArrayList<ResumeProject>();
		param.put("personId", param.get("PERSON_ID"));
		List<Map<String, Object>> retMap = baseDao.selectList("hrms.resume.selectProjectList", param, null);
		int no = 0;
		for(Map<String, Object> map : retMap) {
			ResumeProject project = new ResumeProject();
			project.setNo(String.valueOf(++no));
			project.setProjectName(String.valueOf(map.get("PJ_NAME")));
			project.setDevFrom(String.valueOf(map.get("START_YM")));
			project.setDevTo(String.valueOf(map.get("END_YM")));
			project.setOS("Windows");
			project.setDB("MySQL");
			project.setWorkplace(String.valueOf(map.get("WORK_PLACE")));
			project.setProjectType(String.valueOf(map.get("BUSSNESS_TYPE")));
			project.setDescription(String.valueOf(map.get("WORK_CONTENTS")));
			project.setDevLanguage(String.valueOf(map.get("LANGUAGE")));
			project.setRD(String.valueOf(map.get("PHASE_RD")));
			project.setBD(String.valueOf(map.get("PHASE_BD")));
			project.setFD(String.valueOf(map.get("PHASE_FD")));
			project.setDD(String.valueOf(map.get("PHASE_DD")));
			project.setCD(String.valueOf(map.get("PHASE_CD")));
			project.setUT(String.valueOf(map.get("PHASE_UT")));
			project.setIT(String.valueOf(map.get("PHASE_IT")));
			project.setST(String.valueOf(map.get("PHASE_ST")));
			project.setOT(String.valueOf(map.get("PHASE_OT")));
			project.setCharge(getCharge(map));
			projects.add(project);
		}
		return projects;
	}

	private String getCharge(Map<String, Object> param) {
		String val = "";
		if("1".equals(String.valueOf(param.get("ROLE_TESTER")))) {
			val = val + "/テスター";
		}
		if("1".equals(String.valueOf(param.get("ROLE_PG")))) {
			val = val + "/PG";
		}
		if("1".equals(String.valueOf(param.get("ROLE_SE")))) {
			val = val + "/SE";
		}
		if("1".equals(String.valueOf(param.get("ROLE_BSE")))) {
			val = val + "/BSE";
		}
		if("1".equals(String.valueOf(param.get("ROLE_SL")))) {
			val = val + "/SL";
		}
		if("1".equals(String.valueOf(param.get("ROLE_TL")))) {
			val = val + "/TL";
		}
		if("1".equals(String.valueOf(param.get("ROLE_PM")))) {
			val = val + "/PM";
		}
		if("1".equals(String.valueOf(param.get("ROLE_PMO")))) {
			val = val + "/PMO";
		}
		if("1".equals(String.valueOf(param.get("ROLE_AM")))) {
			val = val + "/AM";
		}
		if("1".equals(String.valueOf(param.get("ROLE_ARCH")))) {
			val = val + "/ARCH";
		}
		if("1".equals(String.valueOf(param.get("ROLE_CONSUL")))) {
			val = val + "/コンサルタント";
		}
		if("1".equals(String.valueOf(param.get("OTHER")))) {
			val = val + "/その他";
		}
		if(!"".equals(val)) {
			val = val.substring(1);
		}
		return val;
	}

	private String getLevelVal(String code, String skillKbn) {
		String val = "";
		if("LAN".equals(skillKbn)) {
			switch(code) {
			case "1":
				val = "知識あり";
				break;
			case "2":
				val = "簡単なプログラミングができる";
				break;
			case "3":
				val = "一人でアプリケーション開発できる";
				break;
			case "4":
				val = "業務で即戦力になれる";
				break;
			case "5":
				val = "メンバー指導できる";
				break;
			default:
				break;
			}
		}else if("DB".equals(skillKbn)) {
			switch(code) {
			case "1":
				val = "知識あり";
				break;
			case "2":
				val = "簡単なSELECT文が書ける";
				break;
			case "3":
				val = "SQLを使ったプログラミングができる";
				break;
			case "4":
				val = "システムの要件に応じてテーブル設計できる";
				break;
			case "5":
				val = "メインPG/メンターとして，主設計を任せられる";
				break;
			default:
				break;
			}
		}else if("OS".equals(skillKbn)) {
			switch(code) {
			case "1":
				val = "知識あり";
				break;
			case "2":
				val = "基本操作ができる";
				break;
			case "3":
				val = "インストールから基本設定までできる";
				break;
			case "4":
				val = "システムデザイン、ネットワーク構築できる";
				break;
			case "5":
				val = "トラブルシューティング、キャパシティプランニングができる";
				break;
			default:
				break;
			}
		}
		return val;
	}
}
