public class Car {
    private String category; // Small, Medium, SUV
    private String manufacturer;
    private String model;
    private int year;
    private double pricePerDay;
    private boolean available;
    private User owner;        // Composition with User
    private Location location;  // Composition with Location
    private String rentedBy; // tracks which username currently rented this car

    public Car(String category, String manufacturer, String model, int year, double pricePerDay, boolean available, User owner, Location location) {
        this.category = category;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.available = available;
        this.owner = owner;
        this.location = location;
    }

    public String getCategory() { return category; }
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPricePerDay() { return pricePerDay; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    public User getOwner() { return owner; }
    public Location getLocation() { return location; }
    public String getRentedBy() { return rentedBy; }
    public void setRentedBy(String rentedBy) { this.rentedBy = rentedBy; }


    @Override
    public String toString() {
        return "Car [" + manufacturer + " " + model + " (" + year + "), Category: " + category +
                ", Price/Day: $" + pricePerDay + ", Available: " + (available ? "Yes" : "No") +
                ", Location: " + location + ", Owner: " + owner.getUsername() + "]";
    }

}