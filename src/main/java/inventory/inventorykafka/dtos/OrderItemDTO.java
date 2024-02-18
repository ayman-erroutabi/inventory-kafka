package inventory.inventorykafka.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemDTO {

    private long id;

    private ProductDTO productEntity;

    private int quantity;

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "id=" + id +
                ", productEntity=" + productEntity.toString() +
                ", quantity=" + quantity +
                '}';
    }
}
