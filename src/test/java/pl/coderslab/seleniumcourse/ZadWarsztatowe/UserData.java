package pl.coderslab.seleniumcourse.ZadWarsztatowe;

public class UserData {
    private String alias;
    private String address;
    private String postCode;
    private String city;
    private String country;
    private String phone;

    public String getAlias() {
        return alias;
    }

    public UserData setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserData setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public UserData setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostCode() {
        return postCode;
    }

    public UserData setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }



    public String getCountry() {
        return country;
    }

    public UserData setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserData setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
