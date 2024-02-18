package inventory.inventorykafka.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class InventoryEntity {

    @Id
    @Column(name="product_id")
    private long id;

    @Column(name = "available_qty")
    private int availableQuantity;

}
