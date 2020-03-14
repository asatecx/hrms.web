package af.base.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import af.base.exception.WebException;

@Scope("request")
@Component("QueryUtil")
public class QueryUtil {
	/**
	 * ORDER BY SQL文の作成 (For Relational DB)
	 *
	 * @return ORDER BY SQL文
	 */
	public static String composeOrderByClause(Map<String, Integer> sortInfo) {
		if (sortInfo == null || sortInfo.isEmpty())
			return "";
		StringBuffer sb = new StringBuffer();
		boolean isFirst = true;
		for (Map.Entry<String, Integer> item : sortInfo.entrySet()) {
			String prop = item.getKey();
			if (StringUtil.isBlank(prop))
				continue;
			StringUtil.CheckSqlInjection(prop);
			if (prop.indexOf(' ') >= 0) {
				throw new WebException("sql injection risk");
			}

			if (isFirst) {
				sb.append(" ORDER BY ");
				isFirst = false;
			} else {
				sb.append(", ");
			}

			sb.append(prop);
			sb.append(" ");

			Integer dir = item.getValue();
			if (dir != null && dir < 0) {
				sb.append("DESC");
			} else {
				sb.append("ASC");
			}
		}

		sb.append(" ");
		return sb.toString();
	}

	/**
	 * get condition for query by filterInfo
	 *
	 * @return condition
	 */
	public static Map<String, Object> getCondition(Map<String, Object> filterInfo, String[] equalFields,
			String[] containFields) {
		Map<String, Object> cond = new HashMap<String, Object>();

		if (equalFields != null && equalFields.length > 0) {
			for (String equalField : equalFields) {
				putValue(cond, equalField, filterInfo.get(equalField));
			}
		}

		if (containFields != null && containFields.length > 0) {
			for (String containField : containFields) {
				String value = (String) filterInfo.get(containField);
				if (!StringUtil.isNullOrEmpty(value)) {
					cond.put(containField, "%" + value.trim() + "%");
				}
			}
		}

		return cond;
	}

	protected static void putValue(Map<String, Object> cond, String key, Object value) {
		if (value != null) {
			if (value.getClass().equals(String.class)) {
				if (!StringUtil.isNullOrEmpty((String) value)) {
					cond.put(key, (String) value);
				}
			}else {
				cond.put(key, value);
			}
		}
	}

}
