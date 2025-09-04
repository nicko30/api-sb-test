package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    private Integer id;
    private String street;
    private String streetName;
    private String buildingNumber;
    private String city;
    private String zipcode;
    private String country;
    private Double latitude;
    private Double longitude;

    @JsonProperty("country_code")
    private String countryCode;

    // Getters
    public Integer getId() { return id; }
    public String getStreet() { return street; }
    public String getStreetName() { return streetName; }
    public String getBuildingNumber() { return buildingNumber; }
    public String getCity() { return city; }
    public String getZipcode() { return zipcode; }
    public String getCountry() { return country; }
    public String getCountryCode() { return countryCode; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setStreet(String street) { this.street = street; }
    public void setStreetName(String streetName) { this.streetName = streetName; }
    public void setBuildingNumber(String buildingNumber) { this.buildingNumber = buildingNumber; }
    public void setCity(String city) { this.city = city; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
    public void setCountry(String country) { this.country = country; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}
