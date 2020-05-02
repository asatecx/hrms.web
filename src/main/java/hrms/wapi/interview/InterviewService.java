package hrms.wapi.interview;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hrms.model.Interview;
import hrms.wapi.base.HrmsSimpleDaoService;

/*************************************************************************
 * Copyright     Asatecx Co.,Ltd.<br/>
 * Package       hrms.wapi.interview<br/>
 * Class         InterviewService<br/>
 * Summary       面接サービス<br/>
 * <br/>
 * Date             Author      Category     Version     Note<br/>
 * 2020/04/25       tang-xf     Add          1.0.0       新規作成<br/>
 ************************************************************************/
@Service("hrms.interviewService")
public class InterviewService extends HrmsSimpleDaoService {

	/**
     * 面接情報登録.
     * @param company
     * @return boolean
     */
	@Transactional("hrms.tx")
	public boolean registInterview(Interview interview) {
		Interview checkInterview = super.find(interview);
		if (checkInterview != null) {
			return false;
		}
		super.insert(true, interview);
		return true;
	}

    /**
     * update interview info.
     * @param companyId company Id
     * @return Company info
     */
	@Transactional("hrms.tx")
	public void updateInterview(Interview interview) {
		// 面接情報更新
		super.updateFree(true, interview,
				new String[] {
						"CASE_NAME",
						"WORK_PLACE",
						"INTERVIEW_PLACE",
						"INTERVIEW_DATE",
						"START_TIME",
						"END_TIME",
						"WORK_CONTENTS",
						"INTERVIEW_RESULT",
						"UPDATE_USER",
						"UPDATED_BY",
						"UPDATE_DATE_TIME" },
						"PERSON_ID",
						"COMPANY_ID",
						"UPDATE_DATE_TIME");
	}

}
