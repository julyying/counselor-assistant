package sixth.sixthgroup.model;

public class Power {
    private Integer poweId;

    private String poweName;

    public Integer getPoweId() {
        return poweId;
    }

    public void setPoweId(Integer poweId) {
        this.poweId = poweId;
    }

    public String getPoweName() {
        return poweName;
    }

    public void setPoweName(String poweName) {
        this.poweName = poweName == null ? null : poweName.trim();
    }
}