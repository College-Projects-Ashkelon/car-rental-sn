public class Car {
    private String manufacturer;
    private String model;
    private int year;
    private String category;
    private double pricePerDay;
    private boolean available;
    private User owner;         // Composition
    private Location location; // Composition

    public Car(String manufacturer, String model, int year, String category, double pricePerDay, User owner, Location location) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.category = category;
        this.pricePerDay = pricePerDay;
        this.available = true; // זמין כברירת מחדל
        this.owner = owner;
        this.location = location;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getOwner() {
        return owner;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Car: " + year + " " + manufacturer + " " + model +
                " | Category: " + category +
                " | Price/Day: $" + pricePerDay +
                " | Available: " + (available ? "Yes" : "No") +
                "\n   Location: " + location +
                "\n   Owner: " + owner;
    }
}