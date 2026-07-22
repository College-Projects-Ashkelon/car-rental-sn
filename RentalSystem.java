public class RentalSystem {
    private User[] users;
    private Car[] cars;
    private Location[] locations;

    private int userCount;
    private int carCount;
    private int locationCount;

    public RentalSystem() {
        // הגדרת מערכים בגודל קבוע
        this.users = new User[100];
        this.cars = new Car[100];
        this.locations = new Location[20];

        // איפוס המונים
        this.userCount = 0;
        this.carCount = 0;

        // יצירה ואכלוס מראש של 10 סניפים קבועים מ-6 ערים שונות
        initLocations();
    }

    private void initLocations() {
        locations[0] = new Location("Tel Aviv", "Central");
        locations[1] = new Location("Tel Aviv", "North");
        locations[2] = new Location("Tel Aviv", "Airport");
        locations[3] = new Location("Jerusalem", "City Center");
        locations[4] = new Location("Jerusalem", "Malha");
        locations[5] = new Location("Haifa", "Downtown");
        locations[6] = new Location("Haifa", "Carmel");
        locations[7] = new Location("Eilat", "Promenade");
        locations[8] = new Location("Be'er Sheva", "University");
        locations[9] = new Location("Netanya", "Beach");

        this.locationCount = 10;
    }

    public User[] getUsers() {
        return users;
    }

    public Car[] getCars() {
        return cars;
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

    public int getLocationCount() {
        return locationCount;
    }
}