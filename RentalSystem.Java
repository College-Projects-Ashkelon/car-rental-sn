import java.util.Scanner;

public class RentalSystem {
    private User[] users;
    private int userCount;
    private Car[] cars;
    private int carCount;
    private Location[] locations;
    private User currentUser;

    public RentalSystem() {
        // Initialize fixed-size arrays according to restrictions
        this.users = new User[100];
        this.userCount = 0;
        this.cars = new Car[100];
        this.carCount = 0;
        this.locations = new Location[10];
        this.currentUser = null; // אין משתמש מחובר בהתחלה

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
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void logout() {
        this.currentUser = null;
        System.out.println("✅ Logged out successfully.");
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
    // === KAN-345: User Registration ===
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
    // ========================================================
    // ⬇️  KAN-360: User login logic ⬇️
    // ========================================================
    public User login(Scanner scanner) {
        System.out.println("\n--- User Login ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        for (int i = 0; i < userCount; i++) {
            // בדיקת שם משתמש (Case-insensitive) ואימות סיסמה דרך checkPassword
            if (users[i].getUsername().equalsIgnoreCase(username) && users[i].checkPassword(password)) {
                this.currentUser = users[i];
                System.out.println("✅ Login successful! Welcome, " + currentUser.getFullName() + " (" + currentUser.getUserType() + ")");
                return currentUser;
            }
        }

        System.out.println("❌ Invalid username or password.");
        return null;
    }
    // =========================================================================
    // ⬇️  KAN-377: Fleet Management ⬇️
    // =========================================================================

    public void addCar(Scanner scanner) {
        System.out.println("\n--- Add New Car to Fleet ---");

        // 📌 [KAN-378] בדיקת אימות התחברות והרשאות Agent בלבד
        if (currentUser == null) {
            System.out.println("❌ You must be logged in to add a car.");
            return;
        }

        if (!"Agent".equalsIgnoreCase(currentUser.getUserType())) {
            System.out.println("❌ Access Denied! Only Rental Agents can add cars to the fleet.");
            return;
        }

        // 📌 [KAN-379] בדיקת מגלבת 10 רכבים לסוכן (Agent Car Limit Enforcement)
        int agentCarCount = 0;
        for (int i = 0; i < carCount; i++) {
            if (cars[i].getOwner().getUsername().equals(currentUser.getUsername())) {
                agentCarCount++;
            }
        }

        if (agentCarCount >= currentUser.getCarLimit()) {
            System.out.println("❌ Limit Reached! You cannot manage more than " + currentUser.getCarLimit() + " cars.");
            return;
        }

        // 📌 [KAN-380] קליטת פרטי הרכב ואימות קלט (מחיר חיובי ושנת ייצור תקינה)
        System.out.print("Enter Car Category (e.g., Sedan, SUV, Compact): ");
        String category = scanner.nextLine().trim();

        System.out.print("Enter Make (e.g., Toyota, Honda): ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter Model (e.g., Civic, RAV4): ");
        String model = scanner.nextLine().trim();

        int year = 0;
        while (true) {
            System.out.print("Enter Year (1990 - 2026): ");
            try {
                year = Integer.parseInt(scanner.nextLine().trim());
                if (year >= 1990 && year <= 2026) {
                    break;
                }
                System.out.println("❌ Invalid year! Must be between 1990 and 2026.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a valid year number.");
            }
        }

        double dailyRate = 0.0;
        while (true) {
            System.out.print("Enter Daily Rate ($): ");
            try {
                dailyRate = Double.parseDouble(scanner.nextLine().trim());
                if (dailyRate > 0) {
                    break;
                }
                System.out.println("❌ Rate must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a numeric price.");
            }
        }

        // בחירת סניף קיים במערכת
        System.out.println("\nSelect Branch Location:");
        for (int i = 0; i < locations.length; i++) {
            System.out.println((i + 1) + ". " + locations[i]);
        }

        int locChoice = -1;
        while (true) {
            System.out.print("Choice (1-" + locations.length + "): ");
            try {
                locChoice = Integer.parseInt(scanner.nextLine().trim()) - 1;
                if (locChoice >= 0 && locChoice < locations.length) {
                    break;
                }
                System.out.println("❌ Invalid selection.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
        }

        Location selectedLocation = locations[locChoice];

        // יצירת הרכב והוספתו למערך הרכבים
        Car newCar = new Car(category, make, model, year, dailyRate, true, currentUser, selectedLocation);
        cars[carCount] = newCar;
        carCount++;

        System.out.println("✅ Car added successfully to the fleet!");
    }

    // 📌 [KAN-381] מנגנון חיפוש והצגת רכבים זמינים בצי
    public void searchCars() {
        System.out.println("\n--- Available Cars in Fleet ---");
        if (carCount == 0) {
            System.out.println("ℹ️ No cars currently available in the system.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < carCount; i++) {
            if (cars[i].isAvailable()) {
                System.out.println("[" + (i + 1) + "] " + cars[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("ℹ️ No available cars found.");
        }
    }
}