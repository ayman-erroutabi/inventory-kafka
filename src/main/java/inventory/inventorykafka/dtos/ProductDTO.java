package inventory.inventorykafka.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {

    private long id;

    private String productName;

    private float price;

    private int availableQuantity;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
