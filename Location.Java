public class Location {
    private String city;
    private String branchName;

    // Constructor
    public Location(String city, String branchName) {
        this.city = city;
        this.branchName = branchName;
    }

    // Getters
    public String getCity() {
        return city;
    }

    public String getBranchName() {
        return branchName;
    }

    @Override
    public String toString() {
        return city + " - " + branchName;
    }
}