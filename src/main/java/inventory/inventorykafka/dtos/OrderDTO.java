package inventory.inventorykafka.dtos;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private long id;

    private CustomerDTO customer;

    private List<OrderItemDTO> orderItemEntities;

    private Date dateCreated;

    private String errorMessage;

    public OrderDTO() {
    }

    public OrderDTO(long id, CustomerDTO customer, List<OrderItemDTO> orderItemEntities, Date dateCreated) {
        this.id = id;
        this.customer = customer;
        this.orderItemEntities = orderItemEntities;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<OrderItemDTO> getOrderItemEntities() {
        return orderItemEntities;
    }

    public void setOrderItemEntities(List<OrderItemDTO> orderItemEntities) {
        this.orderItemEntities = orderItemEntities;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderItemEntities=" + orderItemEntities +
                ", dateCreated=" + dateCreated +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
