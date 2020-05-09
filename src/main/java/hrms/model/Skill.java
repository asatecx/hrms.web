package hrms.model;

import java.util.List;

import lombok.Data;

public class Skill {
	
	/**
	 * @return the tableDataLanguage
	 */
	public List<PeopleSkill> getTableDataLanguage() {
		return tableDataLanguage;
	}
	/**
	 * 
	 */
	public Skill() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param tableDataLanguage the tableDataLanguage to set
	 */
	public void setTableDataLanguage(List<PeopleSkill> tableDataLanguage) {
		this.tableDataLanguage = tableDataLanguage;
	}
	/**
	 * @return the tableDataDB
	 */
	public List<PeopleSkill> getTableDataDB() {
		return tableDataDB;
	}
	/**
	 * @param tableDataDB the tableDataDB to set
	 */
	public void setTableDataDB(List<PeopleSkill> tableDataDB) {
		this.tableDataDB = tableDataDB;
	}
	/**
	 * @return the tableDataOS
	 */
	public List<PeopleSkill> getTableDataOS() {
		return tableDataOS;
	}
	/**
	 * @param tableDataOS the tableDataOS to set
	 */
	public void setTableDataOS(List<PeopleSkill> tableDataOS) {
		this.tableDataOS = tableDataOS;
	}
	private List<PeopleSkill> tableDataLanguage;
	private List<PeopleSkill> tableDataDB;
	private List<PeopleSkill> tableDataOS;



}
