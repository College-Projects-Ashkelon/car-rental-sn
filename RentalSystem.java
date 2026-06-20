public class RentalSystem {
    private static final int MAX_USERS = 100;
    private static final int MAX_CARS = 100;
    private static final int NUM_LOCATIONS = 10;

    private User[] users;
    private Car[] cars;
    private Location[] locations;

    private int userCount;
    private int carCount;

    public RentalSystem() {
        users = new User[MAX_USERS];
        cars = new Car[MAX_CARS];
        userCount = 0;
        carCount = 0;

        // 10 סניפים קבועים מ-4 ערים
        locations = new Location[NUM_LOCATIONS];
        locations[0] = new Location(1, "תל אביב מרכז",    "תל אביב",  "רחוב דיזנגוף 50");
        locations[1] = new Location(2, "תל אביב דרום",    "תל אביב",  "רחוב קיבוץ גלויות 10");
        locations[2] = new Location(3, "תל אביב צפון",    "תל אביב",  "רחוב ארלוזורוב 30");
        locations[3] = new Location(4, "ירושלים מרכז",    "ירושלים",  "רחוב יפו 100");
        locations[4] = new Location(5, "ירושלים גבעה",    "ירושלים",  "רחוב בן גוריון 5");
        locations[5] = new Location(6, "ירושלים מלחה",    "ירושלים",  "קניון מלחה");
        locations[6] = new Location(7, "חיפה נמל",        "חיפה",     "רחוב הנמל 1");
        locations[7] = new Location(8, "חיפה הכרמל",      "חיפה",     "רחוב הנשיא 15");
        locations[8] = new Location(9, "באר שבע מרכז",    "באר שבע",  "רחוב הנשיא 20");
        locations[9] = new Location(10, "באר שבע אוניב'", "באר שבע",  "שד' בן גוריון 1");
    }

    // Getters
    public User[] getUsers() { return users; }
    public Car[] getCars() { return cars; }
    public Location[] getLocations() { return locations; }
    public int getUserCount() { return userCount; }
    public int getCarCount() { return carCount; }
}
