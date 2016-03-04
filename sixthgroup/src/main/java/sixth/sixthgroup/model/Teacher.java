package sixth.sixthgroup.model;

public class Teacher {
    private Integer teacId;

    private Integer teacAcademy;

    private String teacName;

    private String teacSex;

    private Integer teacAge;

    private Integer teacTel;

    private Integer teacQq;

    public Integer getTeacId() {
        return teacId;
    }

    public void setTeacId(Integer teacId) {
        this.teacId = teacId;
    }

    public Integer getTeacAcademy() {
        return teacAcademy;
    }

    public void setTeacAcademy(Integer teacAcademy) {
        this.teacAcademy = teacAcademy;
    }

    public String getTeacName() {
        return teacName;
    }

    public void setTeacName(String teacName) {
        this.teacName = teacName == null ? null : teacName.trim();
    }

    public String getTeacSex() {
        return teacSex;
    }

    public void setTeacSex(String teacSex) {
        this.teacSex = teacSex == null ? null : teacSex.trim();
    }

    public Integer getTeacAge() {
        return teacAge;
    }

    public void setTeacAge(Integer teacAge) {
        this.teacAge = teacAge;
    }

    public Integer getTeacTel() {
        return teacTel;
    }

    public void setTeacTel(Integer teacTel) {
        this.teacTel = teacTel;
    }

    public Integer getTeacQq() {
        return teacQq;
    }

    public void setTeacQq(Integer teacQq) {
        this.teacQq = teacQq;
    }
}