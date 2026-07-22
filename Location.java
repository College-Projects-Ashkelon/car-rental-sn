public class Location {
    private String city;
    private String branchName;

    public Location(String city, String branchName) {
        this.city = city;
        this.branchName = branchName;
    }

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