package niucaocao.domain;

public class InterviewResult {

	private String companyName;
	private String time;
	private String notes;
	private String interviewPlace;
	private String interviewMeetingPlace;
	private String interviewstatus;
	private String comment;
	private String firstDaynotes;
	private String firstDayPlace;
	private String firstDayTime;
	/**
	 * 
	 */
	public InterviewResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param companyName
	 * @param time
	 * @param notes
	 * @param interviewPlace
	 * @param interviewMeetingPlace
	 * @param interviewstatus
	 * @param comment
	 * @param firstDaynotes
	 * @param firstDayPlace
	 * @param firstDayTime
	 */
	public InterviewResult(String companyName, String time, String notes, String interviewPlace,
			String interviewMeetingPlace, String interviewstatus, String comment, String firstDaynotes,
			String firstDayPlace, String firstDayTime) {
		super();
		this.companyName = companyName;
		this.time = time;
		this.notes = notes;
		this.interviewPlace = interviewPlace;
		this.interviewMeetingPlace = interviewMeetingPlace;
		this.interviewstatus = interviewstatus;
		this.comment = comment;
		this.firstDaynotes = firstDaynotes;
		this.firstDayPlace = firstDayPlace;
		this.firstDayTime = firstDayTime;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getInterviewPlace() {
		return interviewPlace;
	}

	public void setInterviewPlace(String interviewPlace) {
		this.interviewPlace = interviewPlace;
	}

	public String getInterviewMeetingPlace() {
		return interviewMeetingPlace;
	}

	public void setInterviewMeetingPlace(String interviewMeetingPlace) {
		this.interviewMeetingPlace = interviewMeetingPlace;
	}

	public String getInterviewstatus() {
		return interviewstatus;
	}

	public void setInterviewstatus(String interviewstatus) {
		this.interviewstatus = interviewstatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFirstDaynotes() {
		return firstDaynotes;
	}

	public void setFirstDaynotes(String firstDaynotes) {
		this.firstDaynotes = firstDaynotes;
	}

	public String getFirstDayPlace() {
		return firstDayPlace;
	}

	public void setFirstDayPlace(String firstDayPlace) {
		this.firstDayPlace = firstDayPlace;
	}

	public String getFirstDayTime() {
		return firstDayTime;
	}

	public void setFirstDayTime(String firstDayTime) {
		this.firstDayTime = firstDayTime;
	}

	@Override
	public String toString() {
		return "InterviewResult [companyName=" + companyName + ", time=" + time + ", notes=" + notes
				+ ", interviewPlace=" + interviewPlace + ", interviewMeetingPlace=" + interviewMeetingPlace
				+ ", interviewstatus=" + interviewstatus + ", comment=" + comment + ", firstDaynotes=" + firstDaynotes
				+ ", firstDayPlace=" + firstDayPlace + ", firstDayTime=" + firstDayTime + "]";
	}
	
}
