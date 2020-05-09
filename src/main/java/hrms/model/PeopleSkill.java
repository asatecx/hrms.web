package hrms.model;

import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;

@Data
@Table(name = "T_B_PERSON_SKILL", schema = "${hrmsdb01Schema}")
public class PeopleSkill extends BaseDataModel{
	private String person_id;
	private String skillkbn ;
	private String skill;
	private String exp;
	private int level;
	private String levelContent;

}
