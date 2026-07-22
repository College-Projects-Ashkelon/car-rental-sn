public class User {
    private String username;
    private String password;
    private String licenseNumber;
    private boolean rentalAgent;

    public User(String username, String password, String licenseNumber, boolean rentalAgent) {
        this.username = username;
        this.password = password;
        this.licenseNumber = licenseNumber;
        this.rentalAgent = rentalAgent;
    }

    public String getUsername() {
        return username;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public boolean isRentalAgent() {
        return rentalAgent;
    }

    // אימות סיסמה מבוסס אנקפסולציה - ללא getPassword()
    public boolean checkPassword(String pass) {
        return this.password != null && this.password.equals(pass);
    }

    // מגבלת רכבים: 10 לסוכן, 3 ללקוח רגיל
    public int getCarLimit() {
        return rentalAgent ? 10 : 3;
    }

    @Override
    public String toString() {
        String role = rentalAgent ? "Rental Agent" : "Customer";
        return "User: " + username + " | License: " + licenseNumber + " | Role: " + role;
    }
}