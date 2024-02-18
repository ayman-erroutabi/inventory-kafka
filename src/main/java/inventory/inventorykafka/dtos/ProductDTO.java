package inventory.inventorykafka.dtos;

public class ProductDTO {

    private long id;

    private String productName;

    private float price;

    private int availableQuantity;

    public ProductDTO() {
        this.productName = null;
        this.price = 0;
    }

    public ProductDTO(String productName, float price) {
        this.productName = productName;
        this.price = price;
    }

    public ProductDTO(int id, String productName, float price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

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
