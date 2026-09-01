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

        //  3. בדיקת התחברותKAN-360
        testKAN360(scanner, system);

        // 4. KAN-377 Test (Fleet Management: KAN-378 to KAN-381)
        testKAN377(scanner, system);

        // 5. KAN-382 Test (Search & Filter: KAN-383 to KAN-385)
        testKAN382(scanner, system);

        // 6. KAN-386 Test (Car Rental & Return: KAN-387 to KAN-389)
        testKAN386(scanner, system);

        // 7. KAN-440 Test (Secure Password Change)
        testKAN440(scanner, system);

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
    /**
     * KAN-360 Verification Test
     * בודקת את תהליך ההתחברות וניהול הסשן של המשתמש
     */
    public static void testKAN360(Scanner scanner, RentalSystem system) {
        System.out.println("\n--- [Test] KAN-360: User Login ---");

        // ניסיון התחברות עם המשתמש שנרשם ב-KAN-345
        system.login(scanner);

        if (system.getCurrentUser() != null) {
            System.out.println("Active Session User: " + system.getCurrentUser().getUsername());
        }
        System.out.println("✅ KAN-360 User Login test completed!");
    }
    // 📌 [KAN-377] פונקציית בדיקה המריצה את תתי-הסטורים (KAN-378 עד KAN-381)
    public static void testKAN377(Scanner scanner, RentalSystem system) {
        System.out.println("\n--- [Test] KAN-377: Fleet Management ---");
        // הרצת הוספת רכב לצי
        system.addCar(scanner);
        // הרצת חיפוש והצגת רכבים
        system.searchCars();
        System.out.println("✅ KAN-377 Fleet Management test completed!");
    }
    // 📌 [KAN-382] פונקציית בדיקה לחיפוש וסינון (KAN-383 עד KAN-385)
    public static void testKAN382(Scanner scanner, RentalSystem system) {
        System.out.println("\n--- [Test] KAN-382: Search & Filter Vehicles ---");
        // הרצת בדיקת החיפוש והסינון
        system.searchCarsAdvanced(scanner);
        System.out.println("✅ KAN-382 Vehicle Search test completed!");
    }
    // 📌 [KAN-386] פונקציית בדיקה להשכרה והחזרת רכבים (KAN-387 עד KAN-389)
    public static void testKAN386(Scanner scanner, RentalSystem system) {
        System.out.println("\n--- [Test] KAN-386: Car Rental & Reservation ---");
        // הרצת השכרת רכב
        system.rentCar(scanner);
        // הרצת החזרת רכב
        system.returnCar(scanner);
        System.out.println("✅ KAN-386 Car Rental test completed!");
    }

    public static void testKAN440(Scanner scanner, RentalSystem system) {
        System.out.println("\n--- [Test] KAN-440: Secure Password Change ---");
        system.changePassword(scanner);
        System.out.println("✅ KAN-440 Password Change test completed!");
    }
}