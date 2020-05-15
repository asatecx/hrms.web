package hrms.wapi.login;

import org.springframework.stereotype.Service;

import hrms.model.Company;
import hrms.model.Constants;
import hrms.model.Login;
import hrms.wapi.base.HrmsSimpleDaoService;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.main.wapi.login<br/>
 * Class         LoginService<br/>
 * Summary       ログインサービス<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/03/12       tang-xf     Add          1.0.0       新規作成<br/>
 ************************************************************************/
@Service
public class LoginService extends HrmsSimpleDaoService {
    /**
     * Select user without password.
     * @param userId
     * @return user
     */
    public Login getUser(String userId) {
        Login user = new Login();
        user.setUserId(userId);
        user = baseDao.find(user);
        if (user != null) {
            if (!Constants.VALID_FLG_TRUE.equals(user.getValidFlg())) {
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
        company = baseDao.find(company);
        return company;
    }

    /**
     * insert loginUser
     * @param Login
     * @return user
     */
    public boolean insertLoginUser(Login user) {

        int result = baseDao.insert(false, user);

        if(result>=1) {
        	return true;
        }else {
        	return false;
        }


    }

}
