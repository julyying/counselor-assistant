package sixth.sixthgroup.model;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userPower;

    private Integer userBelong;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserPower() {
        return userPower;
    }

    public void setUserPower(Integer userPower) {
        this.userPower = userPower;
    }

    public Integer getUserBelong() {
        return userBelong;
    }

    public void setUserBelong(Integer userBelong) {
        this.userBelong = userBelong;
    }
}