package sixth.sixthgroup.model;

import java.util.Date;

public class Diary {
    private Integer diarId;

    private Integer diarUser;

    private String diarContent;

    private Date diarTime;

    private String time;
    
    public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getDiarId() {
        return diarId;
    }

    public void setDiarId(Integer diarId) {
        this.diarId = diarId;
    }

    public Integer getDiarUser() {
        return diarUser;
    }

    public void setDiarUser(Integer diarUser) {
        this.diarUser = diarUser;
    }

    public String getDiarContent() {
        return diarContent;
    }

    public void setDiarContent(String diarContent) {
        this.diarContent = diarContent == null ? null : diarContent.trim();
    }

    public Date getDiarTime() {
        return diarTime;
    }

    public void setDiarTime(Date diarTime) {
        this.diarTime = diarTime;
    }
}