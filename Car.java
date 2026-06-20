public class Car {
    private int id;
    private String licensePlate;
    private String brand;
    private String model;
    private int year;
    private double pricePerDay;
    private boolean available;
    private User owner;
    private Location location;

    public Car(int id, String licensePlate, String brand, String model, int year,
               double pricePerDay, boolean available, User owner, Location location) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.available = available;
        this.owner = owner;
        this.location = location;
    }

    // Getters
    public int getId() { return id; }
    public String getLicensePlate() { return licensePlate; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPricePerDay() { return pricePerDay; }
    public boolean isAvailable() { return available; }
    public User getOwner() { return owner; }
    public Location getLocation() { return location; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setYear(int year) { this.year = year; }
    public void setPricePerDay(double pricePerDay) { this.pricePerDay = pricePerDay; }
    public void setAvailable(boolean available) { this.available = available; }
    public void setOwner(User owner) { this.owner = owner; }
    public void setLocation(Location location) { this.location = location; }

    @Override
    public String toString() {
        return "Car{id=" + id +
               ", licensePlate='" + licensePlate + "'" +
               ", brand='" + brand + "'" +
               ", model='" + model + "'" +
               ", year=" + year +
               ", pricePerDay=" + pricePerDay +
               ", available=" + available +
               ", owner=" + owner +
               ", location=" + location + "}";
    }
}
