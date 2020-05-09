package hrms.model;



import af.base.model.BaseDataModel;
import af.base.orm.annotation.Table;
import lombok.Data;
@Data
@Table(name = "T_B_PERSON_PJ", schema = "${hrmsdb01Schema}")
public class PeopleProject extends BaseDataModel{
	private String	person_id	;
	private String	pj_name	;
	private String	start_ym	;
	private String	end_ym	;
	private String	bussness_type	;
	private String	work_contents	;
	private String	dev_env	;
	private String	work_place	;
	private String	language	;
	private Phase face;
	private Role role;
	private String	memo	;

	private String	phase_rd	;
	private String	phase_bd	;
	private String	phase_fd	;
	private String	phase_dd	;
	private String	phase_cd	;
	private String	phase_ut	;
	private String	phase_it	;
	private String	phase_st	;
	private String	phase_ot	;

	private String	role_tester	;
	private String	role_pg	;
	private String	role_se	;
	private String	role_bse	;
	private String	role_sl	;
	private String	role_tl	;
	private String	role_pm	;
	private String	role_pmo	;
	private String	role_am;
	private String	role_arch;
	private String	role_other	;
	public void readyInsert() {
		this.setRole_tester(role.getRole_tester())	;
		this.setRole_pg(role.getRole_pg())	;
		this.setRole_se(role.getRole_se())	;
		this.setRole_bse(role.getRole_bse())	;
		this.setRole_sl(role.getRole_sl())	;
		this.setRole_tl(role.getRole_tl())	;
		this.setRole_pm(role.getRole_pm())	;
		this.setRole_pmo(role.getRole_pmo())	;
		this.setRole_am(role.getRole_am())	;
		this.setRole_arch(role.getRole_arch())	;
		this.setRole_other(role.getRole_other())	;
		
		this.setPhase_rd(face.getPhase_rd())	;
		this.setPhase_bd(face.getPhase_bd())	;
		this.setPhase_fd(face.getPhase_fd())	;
		this.setPhase_dd(face.getPhase_dd())	;
		this.setPhase_cd(face.getPhase_cd())	;
		this.setPhase_ut(face.getPhase_ut())	;
		this.setPhase_it(face.getPhase_it())	;
		this.setPhase_st(face.getPhase_st())	;
		this.setPhase_ot(face.getPhase_ot())	;
	}
	public void readyresponse() {
		role.setRole_tester(this.getRole_tester())	;
		role.setRole_pg(this.getRole_pg())	;
		role.setRole_se(this.getRole_se())	;
		role.setRole_bse(this.getRole_bse())	;
		role.setRole_sl(this.getRole_sl())	;
		role.setRole_tl(this.getRole_tl())	;
		role.setRole_pm(this.getRole_pm())	;
		role.setRole_pmo(this.getRole_pmo())	;
		role.setRole_am(this.getRole_am())	;
		role.setRole_arch(this.getRole_arch())	;
		role.setRole_other(this.getRole_other())	;
		
		face.setPhase_rd(this.getPhase_rd())	;
		face.setPhase_bd(this.getPhase_bd())	;
		face.setPhase_fd(this.getPhase_fd())	;
		face.setPhase_dd(this.getPhase_dd())	;
		face.setPhase_cd(this.getPhase_cd())	;
		face.setPhase_ut(this.getPhase_ut())	;
		face.setPhase_it(this.getPhase_it())	;
		face.setPhase_st(this.getPhase_st())	;
		face.setPhase_ot(this.getPhase_ot())	;
	}
	
	
}
