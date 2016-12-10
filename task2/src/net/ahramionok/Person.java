package net.ahramionok;

/**
 * Created by Kirill on 05.12.2016.
 */
public class Person {

    private String region;
    private String firstname;
    private String lastname;
    private String middlename;
    private String phoneNumber;
    private String city;
    private String street;
    private int house;
    private int flat;
    private String placeholder;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Person(String firstname, String lastname, String middlename, String phoneNumber, String city,
                  String street, int house, int flat) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    @Override
    public String toString() {
        if (this.region.equals("BY")) {
            placeholder = "+375(29)";
        }
        if (this.region.equals("RU")) {
            placeholder = "+7";
        }
        if (this.region.equals("US")) {
            placeholder = "1-500-";
        }

        return lastname + " " + firstname + " " + middlename + "; "
                + city + "; " + street + "; " + house + "-" + flat + "; " + placeholder + phoneNumber+";";
    }
}
