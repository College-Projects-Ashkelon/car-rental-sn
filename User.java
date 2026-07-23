public class User {
    private String username;
    private String password;
    private String fullName;
    private String licenseNumber;
    private String userType; // "Customer" or "Agent"

    public User(String username, String password, String fullName, String licenseNumber, String userType) {
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

    // Encapsulation: Password check method (No getter for password)
    public boolean checkPassword(String inputPassword) {
        return this.password != null && this.password.equals(inputPassword);
    }

    // Business Logic: Car limit policy based on user type
    public int getCarLimit() {
        if ("Agent".equalsIgnoreCase(this.userType)) {
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