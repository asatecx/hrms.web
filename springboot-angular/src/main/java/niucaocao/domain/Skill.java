package niucaocao.domain;

public class Skill {
	private String skillcategory;
	private String skill;
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
	/**
	 * @return the skillcategory
	 */
	public String getSkillcategory() {
		return skillcategory;
	}
	/**
	 * @param skillcategory the skillcategory to set
	 */
	public void setSkillcategory(String skillcategory) {
		this.skillcategory = skillcategory;
	}
	/**
	 * @return the skill
	 */
	public String getSkill() {
		return skill;
	}
	/**
	 * @param skill the skill to set
	 */
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
