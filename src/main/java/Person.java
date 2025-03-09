import java.util.List;
/*
    METHODS
    - Remove one of the workshops in which the person is involved
 */
 public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private List<Workshop> workshops;

    public Person(String firstName, String lastName, String email, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public void removeWorkshop(Workshop workshop){
        workshops.remove(workshop);
    }

    // GETTERS AND SETTERS
    public String getName() {
        return firstName + " " + lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public List<Workshop> getWorkshops(){
        return workshops;
    }
    public void setWorkshops(List<Workshop> workshops){
        this.workshops = workshops;
    }
    public void setFirstName(String name) {
        this.firstName = name;
    }
    public void setLastName(String name) {
        this.lastName = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}


