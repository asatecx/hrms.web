package hrms.wapi.casemng;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrms.model.Case;
import hrms.model.Company;
import hrms.wapi.base.HrmsSimpleDaoService;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       af.hrms.wapi.casemng<br/>
 * Class         CaseService<br/>
 * Summary       案件管理サービス<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/04/12       tang-xf     Add          1.0.0       新規作成<br/>
 ************************************************************************/
@Service("hrms.caseService")
public class CaseService extends HrmsSimpleDaoService {

    /**
     * get company info.
     * @param companyId company Id
     * @return Company info
     */
    public Company getCaseList(String companyId) {
        Company company = new Company();
        company.setUserId(companyId);
        company = super.find(company);
        return company;
    }

    /**
     * get company info.
     * @param companyId company Id
     * @return Company info
     */
    @Transactional("hrms.tx")
    public boolean registCase(Case companyCase) {
		Case checkCase = super.find(companyCase);
		if (checkCase != null) {
			return false;
		}
		int seq = baseDao.selectOne("hrms.case.selectSeq", companyCase, null);
		companyCase.setSeq(seq);
		super.insert(true, companyCase);
		return true;
    }

}
