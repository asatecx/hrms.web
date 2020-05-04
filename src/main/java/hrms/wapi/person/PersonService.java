package hrms.wapi.person;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrms.model.Company;
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
@Service("hrms.personService")
public class PersonService extends HrmsSimpleDaoService {

	/**
     * 人材検索.
     * @param company
     * @return boolean
     */
	@Transactional("hrms.tx")
	public List<Map<String, Object>> selectPersonList(Map<String, Object> param) {
		return baseDao.selectList("hrms.company.selectPersonList", param, null);
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
