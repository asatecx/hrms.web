package hrms.model;

public class Skill {
	private String skillcategory;
	private String skill;

	private String period;

	private String level;
	/**
	 * 
	 */
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param skillcategory
	 * @param skill
	 */
	public Skill(String skillcategory, String skill) {
		super();
		this.skillcategory = skillcategory;
		this.skill = skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getSkill() {
		return this.skill;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}

}
