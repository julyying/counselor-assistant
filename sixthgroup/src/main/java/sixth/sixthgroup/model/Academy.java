package sixth.sixthgroup.model;

public class Academy {
    private Integer acadId;

    private String acadName;

    public Integer getAcadId() {
        return acadId;
    }

    public void setAcadId(Integer acadId) {
        this.acadId = acadId;
    }

    public String getAcadName() {
        return acadName;
    }

    public void setAcadName(String acadName) {
        this.acadName = acadName == null ? null : acadName.trim();
    }
}