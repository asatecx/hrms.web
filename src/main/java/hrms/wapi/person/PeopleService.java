package hrms.wapi.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrms.model.Company;
import hrms.wapi.base.HrmsSimpleDaoService;
@Service("hrms.peopleService")
public class PeopleService extends HrmsSimpleDaoService {
	/**
     * 会社情報登録.
     * @param company
     * @return boolean
     */
	@Transactional("hrms.tx")
	public boolean registPeople(Company company) {
		Company checkCompany = super.find(company);
		if (checkCompany != null) {
			return false;
		}
		super.insert(true, company);
		return true;
	}
}
