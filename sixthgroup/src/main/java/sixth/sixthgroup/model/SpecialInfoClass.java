package sixth.sixthgroup.model;

public class SpecialInfoClass {
    private Integer spclId;

    private String spclName;

    public Integer getSpclId() {
        return spclId;
    }

    public void setSpclId(Integer spclId) {
        this.spclId = spclId;
    }

    public String getSpclName() {
        return spclName;
    }

    public void setSpclName(String spclName) {
        this.spclName = spclName == null ? null : spclName.trim();
    }
}