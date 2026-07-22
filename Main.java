public class Main {
    public static void main(String[] args) {
        System.out.println("=== Running KAN-340 Verification Check ===");

        // 1. אתחול המערכת ובדיקת 10 הסניפים
        RentalSystem system = new RentalSystem();
        System.out.println("Initial location count: " + system.getLocationCount());

        // 2. יצירת אניאובייקטים לבדיקה
        User agent = new User("sergey_l", "SecurePass123!", "12345678", true);
        Location branch = system.getLocations()[0]; // Tel Aviv - Central

        // 3. יצירת רכב ובדיקת הרכבה (Composition)
        Car car = new Car("Toyota", "Corolla", 2023, "Sedan", 60.0, agent, branch);

        // 4. בדיקת Navigation (שרשרת ההרכבה)
        System.out.println("\n--- Testing Navigation ---");
        System.out.println("Owner Username: " + car.getOwner().getUsername());
        System.out.println("Car City: " + car.getLocation().getCity());

        // 5. בדיקת toString()
        System.out.println("\n--- Car Print Test ---");
        System.out.println(car);

        System.out.println("\n=== All domain model classes compiled successfully! ===");
    }
}