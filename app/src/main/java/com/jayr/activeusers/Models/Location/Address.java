package com.jayr.activeusers.Models.Location;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {
    @SerializedName("street")
    @Expose
    private String street;

    @SerializedName("suite")
    @Expose
    private String suite;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("zipcode")
    @Expose
    private String zipcode;

    @SerializedName("geo")
    @Expose
    private Location location;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Location getLocation() {
        return location;
    }

    public Address(String street, String suite, String city, String zipcode, Location location) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", location=" + location +
                '}';
    }

}
