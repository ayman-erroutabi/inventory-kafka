package inventory.inventorykafka.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class InventoryEntity {

    @Id
    @Column(name="product_id")
    private long id;

    @Column(name = "available_qty")
    private int availableQuantity;

    public InventoryEntity() {
    }

    public InventoryEntity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
