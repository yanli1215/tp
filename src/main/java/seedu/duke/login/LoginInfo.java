package seedu.duke.login;

public class LoginInfo {
    private String userId;

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public LoginInfo(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public String strAddToTxt() {
        return getUserId() + " | " + getPassword();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LoginInfo) {
            LoginInfo loginInfoObj = (LoginInfo) obj;
            return getUserId().equals(loginInfoObj.getUserId())
                    && getPassword().equals(loginInfoObj.getPassword());
        }

        return false;
    }


}
