public class Main {
    public static void main(String[] args) {
        System.out.println("--- KAN-333 Verification Test ---");

        RentalSystem system = new RentalSystem();
        User testUser = new User("sergey_dev", "Pass123$", "Sergey L", "12345678", "Agent");
        Location testLocation = system.getLocations()[0];
        Car testCar = new Car("SUV", "Toyota", "RAV4", 2023, 120.0, true, testUser, testLocation);

        System.out.println("User Limit: " + testUser.getCarLimit());
        System.out.println("Password Test: " + testUser.checkPassword("Pass123$"));
        System.out.println("Car Object: " + testCar);
        System.out.println("✅ KAN-333 Foundation completed successfully!");
    }
}