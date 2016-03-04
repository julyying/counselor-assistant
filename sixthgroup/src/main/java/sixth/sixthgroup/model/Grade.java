package sixth.sixthgroup.model;

public class Grade {
    private Integer gradId;

    private String gradName;

    private Integer gradAcademy;

    private Integer gradCounselor;

    private Integer gradMonitor;

    public Integer getGradId() {
        return gradId;
    }

    public void setGradId(Integer gradId) {
        this.gradId = gradId;
    }

    public String getGradName() {
        return gradName;
    }

    public void setGradName(String gradName) {
        this.gradName = gradName == null ? null : gradName.trim();
    }

    public Integer getGradAcademy() {
        return gradAcademy;
    }

    public void setGradAcademy(Integer gradAcademy) {
        this.gradAcademy = gradAcademy;
    }

    public Integer getGradCounselor() {
        return gradCounselor;
    }

    public void setGradCounselor(Integer gradCounselor) {
        this.gradCounselor = gradCounselor;
    }

    public Integer getGradMonitor() {
        return gradMonitor;
    }

    public void setGradMonitor(Integer gradMonitor) {
        this.gradMonitor = gradMonitor;
    }
}