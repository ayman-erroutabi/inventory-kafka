package inventory.inventorykafka.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryDTO {

    private int id;

    private int availableQuantity;

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "id=" + id +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
