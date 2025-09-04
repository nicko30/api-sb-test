package api.model;

import java.util.List;

public class Company {
    private Integer id;
    private String name;
    private String email;
    private String vat;
    private String phone;
    private String country;
    private List<Address> addresses;
    private String website;
    private String image;
    private Contact contact;

    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getVat() { return vat; }
    public String getPhone() { return phone; }
    public String getCountry() { return country; }
    public List<Address> getAddresses() { return addresses; }
    public String getWebsite() { return website; }
    public String getImage() { return image; }
    public Contact getContact() { return contact; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setVat(String vat) { this.vat = vat; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCountry(String country) { this.country = country; }
    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }
    public void setWebsite(String website) { this.website = website; }
    public void setImage(String image) { this.image = image; }
    public void setContact(Contact contact) { this.contact = contact; }
}
