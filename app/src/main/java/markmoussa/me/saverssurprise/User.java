package markmoussa.me.saverssurprise;

public class User {
    private String city;
    private String street;
    private String state;
    private String zip;
    private String phone;
    private String uid;

    public User() {}
    public User(String street, String city, String state, String zip, String phone, String uid) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.uid = uid;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }
    public String getPhone() {
        return phone;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
