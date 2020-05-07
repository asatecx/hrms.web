package hrms.wapi.person;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import af.base.util.DateUtils;
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
     * 人材一覧検索.
     * @param company
     * @return boolean
     */
	@Transactional("hrms.tx")
	public List<Map<String, Object>> selectPersonList(Map<String, Object> param) {
		List<Map<String, Object>> personList = baseDao.selectList("hrms.company.selectPersonList", param, null);
		for(Map<String, Object> map : personList) {
			int age = DateUtils.getAge(String.valueOf(map.get("BIRTHDAY")));
			map.put("age", age);
		}
		return personList;
	}

	/**
     * 人材詳細検索.
     * @param personId
     * @return Map<String, Object>
     */
	@Transactional("hrms.tx")
	public Map<String, Object> selectPersonDetail(Map<String, String> param) {
		return baseDao.selectOne("hrms.company.selectPersonList", param, null);
	}

}
