package sixth.sixthgroup.model;

import java.util.Date;

public class SpecialInfo {
    private Integer spinId;

    private Integer spinStudentid;

    private Integer spinClassno;

    private Date spinTime;
    
    private Integer spinIsread;
    
    private String studName;
    
    private String studNum;
    
    private String gradName;
    
    private String studTel;
    
    private String studDorimitory;
    
    String time;
    
	public Integer getSpinIsread() {
		return spinIsread;
	}

	public void setSpinIsread(Integer spinIsread) {
		this.spinIsread = spinIsread;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getStudDorimitory() {
		return studDorimitory;
	}

	public void setStudDorimitory(String studDorimitory) {
		this.studDorimitory = studDorimitory;
	}

	public Date getSpinTime() {
		return spinTime;
	}

	public void setSpinTime(Date spinTime) {
		this.spinTime = spinTime;
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

	public Integer getSpinId() {
        return spinId;
    }

    public void setSpinId(Integer spinId) {
        this.spinId = spinId;
    }

    public Integer getSpinStudentid() {
        return spinStudentid;
    }

    public void setSpinStudentid(Integer spinStudentid) {
        this.spinStudentid = spinStudentid;
    }

    public Integer getSpinClassno() {
        return spinClassno;
    }

    public void setSpinClassno(Integer spinClassno) {
        this.spinClassno = spinClassno;
    }
}