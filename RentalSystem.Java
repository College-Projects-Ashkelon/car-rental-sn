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
}