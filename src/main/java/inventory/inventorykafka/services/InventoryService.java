package inventory.inventorykafka.services;

import inventory.inventorykafka.dtos.OrderDTO;

public interface InventoryService {
    public boolean isInventoryAndAvailableQuantity(long id, int qty);
    public void updateInventory(Integer qty, Long id);
    public void processOrder(OrderDTO orderDTO, String topicName);
    Integer getProductQuantity(Long id);
}
