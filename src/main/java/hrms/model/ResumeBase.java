package hrms.model;

import lombok.Data;

@Data
public class ResumeBase {
	/**
	 * 姓名(漢字)
	 */
	private String nameKj;
	/**
	 * 姓名(カナ)
	 */
	private String nameKn;
	/**
	 * 性別
	 */
	private String gender;
	/**
	 * 生年月日
	 */
	private String birthday;
	/**
	 * 年齢
	 */
	private String age;
	/**
	 * 日本語レベル
	 */
	private String jpLevel;
	/**
	 * 国籍
	 */
	private String country;
	/**最寄り駅
	 */
	private String station;
	/**
	 * 最終学歴
	 */
	private String education;
	/**
	 * 専攻
	 */
	private String major;
	/**
	 * 卒業年月
	 */
	private String graduation;
	/**
	 * 来日年数
	 */
	private String japanYears;
	/**
	 * 実務経験
	 */
	private String workYears;

}