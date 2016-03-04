package sixth.sixthgroup.model;

import java.util.Date;

public class Student {
    private Integer studId;

    private Integer studGradeid;

    private String studName;

    private String studSex;

    private String studAge;

    private String studTel;

    private String studQq;

    private String studAddress;

    private String studIdcard;

    private String studNum;

    private Date studBron;

    private String studBanknum;

    private String studNation;

    private String studDorimitory;

    private String studParentname;

    private String studParenttel;

    private String bothTime;
    
    private String gradName;
    
    public String getGradName() {
		return gradName;
	}

	public void setGradName(String gradName) {
		this.gradName = gradName;
	}

	public String getBothTime() {
		return bothTime;
	}

	public void setBothTime(String bothTime) {
		this.bothTime = bothTime;
	}

	public Integer getStudId() {
        return studId;
    }

    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public Integer getStudGradeid() {
        return studGradeid;
    }

    public void setStudGradeid(Integer studGradeid) {
        this.studGradeid = studGradeid;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName == null ? null : studName.trim();
    }

    public String getStudSex() {
        return studSex;
    }

    public void setStudSex(String studSex) {
        this.studSex = studSex == null ? null : studSex.trim();
    }

    public String getStudAge() {
        return studAge;
    }

    public void setStudAge(String studAge) {
        this.studAge = studAge == null ? null : studAge.trim();
    }

    public String getStudTel() {
        return studTel;
    }

    public void setStudTel(String studTel) {
        this.studTel = studTel == null ? null : studTel.trim();
    }

    public String getStudQq() {
        return studQq;
    }

    public void setStudQq(String studQq) {
        this.studQq = studQq == null ? null : studQq.trim();
    }

    public String getStudAddress() {
        return studAddress;
    }

    public void setStudAddress(String studAddress) {
        this.studAddress = studAddress == null ? null : studAddress.trim();
    }

    public String getStudIdcard() {
        return studIdcard;
    }

    public void setStudIdcard(String studIdcard) {
        this.studIdcard = studIdcard == null ? null : studIdcard.trim();
    }

    public String getStudNum() {
        return studNum;
    }

    public void setStudNum(String studNum) {
        this.studNum = studNum == null ? null : studNum.trim();
    }

    public Date getStudBron() {
        return studBron;
    }

    public void setStudBron(Date studBron) {
        this.studBron = studBron;
    }

    public String getStudBanknum() {
        return studBanknum;
    }

    public void setStudBanknum(String studBanknum) {
        this.studBanknum = studBanknum == null ? null : studBanknum.trim();
    }

    public String getStudNation() {
        return studNation;
    }

    public void setStudNation(String studNation) {
        this.studNation = studNation == null ? null : studNation.trim();
    }

    public String getStudDorimitory() {
        return studDorimitory;
    }

    public void setStudDorimitory(String studDorimitory) {
        this.studDorimitory = studDorimitory == null ? null : studDorimitory.trim();
    }

    public String getStudParentname() {
        return studParentname;
    }

    public void setStudParentname(String studParentname) {
        this.studParentname = studParentname == null ? null : studParentname.trim();
    }

    public String getStudParenttel() {
        return studParenttel;
    }

    public void setStudParenttel(String studParenttel) {
        this.studParenttel = studParenttel == null ? null : studParenttel.trim();
    }
}