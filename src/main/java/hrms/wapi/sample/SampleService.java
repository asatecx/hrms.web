package hrms.wapi.sample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrms.wapi.base.HrmsSimpleDaoService;
@Service("hrms.sampleService")
public class SampleService extends HrmsSimpleDaoService{

	/**
	 * Insert user.
	 *
	 * @param Object Object
	 */
	@Transactional("hrms.tx")
	public boolean insertUser(Object param) {
		super.insert(true, param);
		return true;
	}

	/**
	 * edit Object.
	 *
	 * @param Object Object
	 */
	@Transactional("hrms.tx")
	public void editObject(Object param) {
		// お知らせ情報更新
		super.updateFree(true, param,
				new String[] { "COLUMN1", "COLUMN2", "COLUMN3","UPDATE_USER",
						"UPDATED_BY", "UPDATE_DATE_TIME" },
				"KEY1", "KEY2");
	}

	public List<Map<String, Object>> getObjects(Object searchCondition) {
		Map<String, Object> cond = new HashMap<String, Object>();
		cond.put("key1", "value");
		List<Map<String, Object>> list = baseDao.selectList("statementName", cond, 1, 100, null);
		return list;
	}

}
