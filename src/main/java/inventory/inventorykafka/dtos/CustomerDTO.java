package inventory.inventorykafka.dtos;


public class CustomerDTO {

    private long id;

    private String customerName;

    private String email;

    private String address;

    public CustomerDTO() {
        this.customerName = null;
        this.email = null;
        this.address = null;
    }

    public CustomerDTO(String customerName, String email, String address) {
        this.customerName = customerName;
        this.email = email;
        this.address = address;
    }

    public CustomerDTO(int id, String customerName, String email, String address) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
