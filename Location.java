public class Location {
    private int id;
    private String name;
    private String city;
    private String address;

    public Location(int id, String name, String city, String address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getCity() { return city; }
    public String getAddress() { return address; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCity(String city) { this.city = city; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Location{id=" + id + ", name='" + name + "', city='" + city + "', address='" + address + "'}";
    }
}
