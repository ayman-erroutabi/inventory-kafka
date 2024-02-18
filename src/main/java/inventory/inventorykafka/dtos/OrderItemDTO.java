package inventory.inventorykafka.dtos;

public class OrderItemDTO {

    private long id;

    private ProductDTO productEntity;

    private int quantity;

    public OrderItemDTO() {
    }

    public OrderItemDTO(long id, OrderDTO orderEntity, ProductDTO productEntity, int quantity) {
        this.id = id;
        this.productEntity = productEntity;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDTO getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductDTO productEntity) {
        this.productEntity = productEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "id=" + id +
                ", productEntity=" + productEntity.toString() +
                ", quantity=" + quantity +
                '}';
    }
}
