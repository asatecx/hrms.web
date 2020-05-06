package hrms.wapi.resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrms.model.Skill;
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
		List<Skill> langList = new ArrayList<Skill>();
		List<Skill> dbList = new ArrayList<Skill>();
		List<Skill> osList = new ArrayList<Skill>();
		param.put("personId", param.get("PERSON_ID"));
		List<Map<String, Object>> skills = baseDao.selectList("hrms.resume.selectSkills", param, null);
		for(Map<String, Object> map : skills) {
			Skill skill = new Skill();
			skill.setSkill(String.valueOf(map.get("SKILL")));
			skill.setPeriod(String.valueOf(map.get("EXP")));
			skill.setLevel(getLevelVal(String.valueOf(map.get("LEVEL")), String.valueOf(map.get("SKILLKBN"))));
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

	/**
     * 人材詳細検索.
     * @param personId
     * @return Map<String, Object>
     */
	@Transactional("hrms.tx")
	public Map<String, Object> selectPersonDetail(Map<String, String> param) {
		return baseDao.selectOne("hrms.company.selectPersonList", param, null);
	}

}
