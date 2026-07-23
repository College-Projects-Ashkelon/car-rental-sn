import java.util.Scanner;

public class RentalSystem {
    private User[] users;
    private int userCount;
    private Car[] cars;
    private int carCount;
    private Location[] locations;

    public RentalSystem() {
        // Initialize fixed-size arrays according to restrictions
        this.users = new User[100];
        this.userCount = 0;
        this.cars = new Car[100];
        this.carCount = 0;
        this.locations = new Location[10];

        // Pre-populate 10 fixed locations across at least 3 cities
        initLocations();
    }

    private void initLocations() {
        locations[0] = new Location("Tel Aviv", "Central");
        locations[1] = new Location("Tel Aviv", "Airport");
        locations[2] = new Location("Tel Aviv", "North");
        locations[3] = new Location("Haifa", "Downtown");
        locations[4] = new Location("Haifa", "Bay");
        locations[5] = new Location("Jerusalem", "Center");
        locations[6] = new Location("Jerusalem", "South");
        locations[7] = new Location("Beer Sheva", "Main");
        locations[8] = new Location("Eilat", "Port");
        locations[9] = new Location("Eilat", "City Center");
    }

    public Location[] getLocations() {
        return locations;
    }

    public int getUserCount() {
        return userCount;
    }

    public int getCarCount() {
        return carCount;
    }
    // ========================================================
    // ⬇️  KAN-345 ⬇️
    // ========================================================

    private static boolean isStrongPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (c == '$' || c == '%' || c == '_') {
                hasSpecialChar = true;
            }
        }
        return hasDigit && hasSpecialChar;
    }

    private static boolean isValidLicense(String license) {
        if (license == null || license.length() != 8) {
            return false;
        }
        for (int i = 0; i < license.length(); i++) {
            if (!Character.isDigit(license.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isUsernameTaken(String username) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public void createUser(Scanner scanner) {
        System.out.println("\n--- User Registration ---");

        String username = "";
        while (true) {
            System.out.print("Enter username: ");
            username = scanner.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("❌ Username cannot be empty.");
            } else if (isUsernameTaken(username)) {
                System.out.println("❌ Username is already taken! Choose a different one.");
            } else {
                break;
            }
        }

        String password = "";
        while (true) {
            System.out.print("Enter password (at least 1 digit and 1 special char '$', '%', '_'): ");
            password = scanner.nextLine().trim();
            if (isStrongPassword(password)) {
                break;
            } else {
                System.out.println("❌ Weak password! Password must contain at least one digit and one special character ($, %, _).");
            }
        }

        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine().trim();

        String licenseNumber = "";
        while (true) {
            System.out.print("Enter driver license number (8 digits): ");
            licenseNumber = scanner.nextLine().trim();
            if (isValidLicense(licenseNumber)) {
                break;
            } else {
                System.out.println("❌ Invalid license number! Must be exactly 8 digits.");
            }
        }

        String userType = "";
        while (true) {
            System.out.println("Select User Type:");
            System.out.println("1. Rental Agent (Up to 10 cars)");
            System.out.println("2. Customer (Up to 3 cars)");
            System.out.print("Choice (1 or 2): ");
            String choice = scanner.nextLine().trim();
            if ("1".equals(choice)) {
                userType = "Agent";
                break;
            } else if ("2".equals(choice)) {
                userType = "Customer";
                break;
            } else {
                System.out.println("❌ Invalid option. Please enter 1 or 2.");
            }
        }

        User newUser = new User(username, password, fullName, licenseNumber, userType);
        users[userCount] = newUser;
        userCount++;

        System.out.println("✅ User registered successfully! (" + userType + " account created)");
    }
}