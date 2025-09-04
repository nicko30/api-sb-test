package api.model;

public class Contact {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String birthday;
    private String gender;
    private Address address;
    private String website;
    private String image;

    // Getters
    public Integer getId() { return id; }
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getBirthday() { return birthday; }
    public String getGender() { return gender; }
    public Address getAddress() { return address; }
    public String getWebsite() { return website; }
    public String getImage() { return image; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setBirthday(String birthday) { this.birthday = birthday; }
    public void setGender(String gender) { this.gender = gender; }
    public void setAddress(Address address) { this.address = address; }
    public void setWebsite(String website) { this.website = website; }
    public void setImage(String image) { this.image = image; }
}
