package sixth.sixthgroup.model;

import java.util.Date;

public class HistoryStudent {
    private Integer histId;

    private Integer histStudentid;

    private Date histTime;
    
    private int studId;
    
    private String studName;
    
    private String studNum;
    
    private String gradName;
    
    private String studTel;

    public int getStudId() {
		return studId;
	}

    String time;
    
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudNum() {
		return studNum;
	}

	public void setStudNum(String studNum) {
		this.studNum = studNum;
	}

	public String getGradName() {
		return gradName;
	}

	public void setGradName(String gradName) {
		this.gradName = gradName;
	}

	public String getStudTel() {
		return studTel;
	}

	public void setStudTel(String studTel) {
		this.studTel = studTel;
	}

	public Integer getHistId() {
        return histId;
    }

    public void setHistId(Integer histId) {
        this.histId = histId;
    }

    public Integer getHistStudentid() {
        return histStudentid;
    }

    public void setHistStudentid(Integer histStudentid) {
        this.histStudentid = histStudentid;
    }

    public Date getHistTime() {
        return histTime;
    }

    public void setHistTime(Date histTime) {
        this.histTime = histTime;
    }
}