package hrms.model;

import lombok.Data;

@Data
public class ResumeProject {
	/**
	 * 番号
	 */
	private String no;
	/**
	 * 開発期間開始
	 */
	private String devFrom;
	/**
	 * 開発期間終了
	 */
	private String devTo;
	/**
	 * 勤務地
	 */
	private String workplace;
	/**
	 * プロジェクト名称
	 */
	private String projectName;
	/**
	 * プロジェクト種別
	 */
	private String projectType;
	/**
	 * プロジェクト紹介
	 */
	private String description;
	/**
    * OS
    */
	private String OS;
	/**
	 * DB
	*/
	private String DB;
	/**
	 * 開発環境
	 */
	private String devEnv;
	/**
	 * 開発言語
	 */
	private String devLanguage;
	/**
	 * 開発ツール
	 */
	private String devTool;
	/**
	 * 担当役割
	 */
	private String charge;
	/**
	 * 要件定義
	 */
	private String RD;
	/**
	 * 基本設計
	 */
	private String BD;
	/**
	 * 機能設計
	 */
	private String FD;
	/**
	 * 詳細設計
	 */
	private String DD;
	/**
	 * 製造
	 */
	private String CD;
	/**
	 * 単体テスト
	 */
	private String UT;
	/**
	 * 結合テスト
	 */
	private String IT;
	/**
	 * 総合テスト
	 */
	private String ST;
	/**
	 * 運用保守
	 */
	private String OT;

}