package hrms.wapi.login;

import org.springframework.stereotype.Service;

import af.base.service.BaseService;
import af.main.model.Login;
import hrms.model.Company;
import hrms.model.Constants;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       pf.main.wapi.login<br/>
 * Class         LoginService<br/>
 * Summary       ログインサービス<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/03/12       tang-xf     Add          1.0.0       新規作成<br/>
 ************************************************************************/
@Service
public class LoginService extends BaseService {
    /**
     * Select user without password.
     * @param userId
     * @return user
     */
    public Login getUser(String userId) {
        Login user = new Login();
        user.setUSER_ID(userId);
        user = mainDao.find(user);
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
        company = mainDao.find(company);
        return company;
    }

}
