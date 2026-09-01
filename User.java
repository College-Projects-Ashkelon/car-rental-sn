public class User {
    private String username;
    private String password;
    private String fullName;
    private String licenseNumber;
    private String userType;

    public User(String username, String password, String fullName,
                String licenseNumber, String userType) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.licenseNumber = licenseNumber;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getUserType() {
        return userType;
    }

    public boolean checkPassword(String inputPassword) {
        return password != null && password.equals(inputPassword);
    }

    public void changePassword(String newPassword) {
        password = newPassword;
    }

    public int getCarLimit() {
        if ("Agent".equalsIgnoreCase(userType)) {
            return 10;
        }

        return 3;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}