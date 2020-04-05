package hrms.model;

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
	 * データベース
	 */
	private String DB;
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
	 * 開発フェーズ
	 */
	private DevPhase devPhase;

	public void setNo(String no) {
		this.no = no;
	}

	public String getNo() {
		return this.no;
	}

	public void setDevFrom(String devFrom) {
		this.devFrom = devFrom;
	}

	public String getDevFrom() {
		return this.devFrom;
	}

	public void setDevTo(String devTo) {
		this.devTo = devTo;
	}

	public String getDevTo() {
		return this.devTo;
	}

	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}

	public String getWorkplace() {
		return this.workplace;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	public void setOS(String OS) {
		this.OS = OS;
	}

	public String getOS() {
		return this.OS;
	}

	public void setDB(String DB) {
		this.DB = DB;
	}

	public String getDB() {
		return this.DB;
	}

	public void setDevLanguage(String devLanguage) {
		this.devLanguage = devLanguage;
	}

	public String getDevLanguage() {
		return this.devLanguage;
	}

	public void setDevTool(String devTool) {
		this.devTool = devTool;
	}

	public String getDevTool() {
		return this.devTool;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getCharge() {
		return this.charge;
	}

	public void setDevPhase(DevPhase devPhase) {
		this.devPhase = devPhase;
	}

	public DevPhase getDevPhase() {
		return this.devPhase;
	}

}