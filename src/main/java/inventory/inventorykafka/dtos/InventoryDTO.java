package inventory.inventorykafka.dtos;

public class InventoryDTO {

    private int id;

    private int availableQuantity;

    public InventoryDTO() {
        this.availableQuantity = 0;
    }

    public InventoryDTO(int id, int availableQuantity) {
        this.id = id;
        this.availableQuantity = availableQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "id=" + id +
                ", availableQuantity=" + availableQuantity +
                '}';
    }
}
