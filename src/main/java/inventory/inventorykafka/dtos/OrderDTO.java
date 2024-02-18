package inventory.inventorykafka.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderDTO {

    private long id;

    private CustomerDTO customer;

    private List<OrderItemDTO> orderItemEntities;

    private Date dateCreated;

    private String errorMessage;

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
