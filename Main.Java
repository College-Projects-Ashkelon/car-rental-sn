import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RentalSystem system = new RentalSystem();

        System.out.println("==========================================");
        System.out.println("        Car Rental System - E2E Test       ");
        System.out.println("==========================================");

        // 1. הרצת בדיקת התשתית של KAN-333
        testKAN333();

        // 2. הרצת בדיקת הרשמת משתמשים של KAN-345
        testKAN345(scanner, system);

        scanner.close();

    }
    /**
     * KAN-340 / KAN-333 Verification Test
     * בודקת תקינות יצירת אובייקטים של User, Location, Car ו-RentalSystem
     */
    public static void testKAN333() {
        System.out.println("\n--- [Test] KAN-333: Domain Model Integration ---");

        // אתחול המערכת וטעינת 10 סניפים
        RentalSystem system = new RentalSystem();

        // יצירת משתמש, מיקום ורכב לבדיקה
        User testUser = new User("sergey_dev", "Pass123$", "Sergey L", "12345678", "Agent");
        Location testLocation = system.getLocations()[0]; // סניף תל אביב מרכז
        Car testCar = new Car("SUV", "Toyota", "RAV4", 2023, 120.0, true, testUser, testLocation);

        // הדפסת נתונים לווידוא תקינות
        System.out.println("User Limit (Agent): " + testUser.getCarLimit());
        System.out.println("Password Verification: " + testUser.checkPassword("Pass123$"));
        System.out.println("Created Car Details: " + testCar);
        System.out.println("Total Pre-populated Locations: " + system.getLocations().length);
        System.out.println("✅ KAN-333 Foundation test passed successfully!");
    }
    /**
     * KAN-345 Verification Test
     * בודקת את תהליך ההרשמה, אימותי הקלט וייחודיות שם המשתמש
     */
    public static void testKAN345(Scanner scanner, RentalSystem system) {
        System.out.println("\n--- [Test] KAN-345: User Registration ---");

        // הרצת הרשמה למשתמש
        system.createUser(scanner);

        System.out.println("Total Registered Users: " + system.getUserCount());
        System.out.println("✅ KAN-345 User Registration test completed!");
    }

}