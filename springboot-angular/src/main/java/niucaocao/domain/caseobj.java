package niucaocao.domain;

public class caseobj {

	private int id;
	private String content;
	//案件名
	private String caseName;
    //業務内容
	private String busiContent;
    //必須スキル
	private String mustSkill;
    //尚可
	private String notMustSkill;
    //参画時期
	private String projectInterval;
    //その他
	private String others;
	/**
	 * 
	 */
	public caseobj() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param content
	 * @param caseName
	 * @param busiContent
	 * @param mustSkill
	 * @param notMustSkill
	 * @param projectInterval
	 * @param others
	 */
	public caseobj(int id, String content, String caseName, String busiContent, String mustSkill, String notMustSkill,
			String projectInterval, String others) {
		super();
		this.id = id;
		this.content = content;
		this.caseName = caseName;
		this.busiContent = busiContent;
		this.mustSkill = mustSkill;
		this.notMustSkill = notMustSkill;
		this.projectInterval = projectInterval;
		this.others = others;
	}
	public caseobj(int id, String content) {
		super();
		this.id = id;
		this.content = content;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public String getBusiContent() {
		return busiContent;
	}
	public void setBusiContent(String busiContent) {
		this.busiContent = busiContent;
	}
	public String getMustSkill() {
		return mustSkill;
	}
	public void setMustSkill(String mustSkill) {
		this.mustSkill = mustSkill;
	}
	public String getNotMustSkill() {
		return notMustSkill;
	}
	public void setNotMustSkill(String notMustSkill) {
		this.notMustSkill = notMustSkill;
	}
	public String getProjectInterval() {
		return projectInterval;
	}
	public void setProjectInterval(String projectInterval) {
		this.projectInterval = projectInterval;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}

	@Override
	public String toString() {
		return "caseobj [id=" + id + ", content=" + content + ", caseName=" + caseName + ", busiContent=" + busiContent
				+ ", mustSkill=" + mustSkill + ", notMustSkill=" + notMustSkill + ", projectInterval=" + projectInterval
				+ ", others=" + others + "]";
	}
	
}
