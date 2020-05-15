package hrms.wapi.company;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import af.main.model.Login;
import af.main.model.User;
import hrms.model.Company;
import hrms.model.Constants;
import hrms.wapi.base.HrmsSimpleDaoService;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.main.wapi.company<br/>
 * Class         CompanyService<br/>
 * Summary       会社サービス<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/04/09       tang-xf     Add          1.0.0       新規作成<br/>
 ************************************************************************/
@Service("hrms.companyService")
public class CompanyService extends HrmsSimpleDaoService {

	/**
     * 会社情報登録.
     * @param company
     * @return boolean
     */
	@Transactional("hrms.tx")
	public boolean registCompany(Company company, Login login) {
		Login checkUser = super.find(login);
		if (checkUser != null) {
			return false;
		}
		super.insert(true, login);
		super.insert(true, company);
		return true;
	}
    /**
     * Select user without password.
     * @param userId
     * @return user
     */
    public User getUser(String userId) {
        User user = new User();
        user.setUSER_ID(userId);
        user = super.find(user);
        if (user != null) {
            if (!Constants.VALID_FLG_TRUE.equals(user.getVALID_FLG())) {
                user = null;
            } else {
                // TODO Somethig
            }
        }
        return user;
    }

    /**
     * get company info.
     * @param companyId company Id
     * @return Company info
     */
    public Company getCompany(String companyId) {
        Company company = new Company();
        company.setUserId(companyId);
        company = super.find(company);
        return company;
    }

}
