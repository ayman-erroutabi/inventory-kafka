package inventory.inventorykafka;

import inventory.inventorykafka.constants.KafkaConstants;
import inventory.inventorykafka.dtos.OrderDTO;
import inventory.inventorykafka.dtos.OrderItemDTO;
import inventory.inventorykafka.services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

@Component
@Slf4j
public class KafkaListeners {

    private final InventoryService inventoryService;

    KafkaListeners(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics= KafkaConstants.KAFKA_TOPIC_ORDERS, groupId = KafkaConstants.KAFKA_GROUP_ID_DEMO, containerFactory = "orderFactory")
    void listener(OrderDTO data){
        boolean areProductsAvailable = true;
        log.warn("Listener received : " + data + "!");
        HashMap<Long, Integer> toUpdateInventory = new HashMap<>();
        if(!Objects.isNull(data)){
            for ( OrderItemDTO orderItem : data.getOrderItemEntities() ) {
                if(!this.inventoryService.isInventoryAndAvailableQuantity(orderItem.getProductEntity().getId(),orderItem.getQuantity())){
                    data.setErrorMessage("The product " + orderItem.getProductEntity().getProductName()
                            + " with id : " + orderItem.getProductEntity().getId() + " has insufficient quantity : " + orderItem.getQuantity());
                    areProductsAvailable = false;
                    break;
                }
                toUpdateInventory.put(orderItem.getProductEntity().getId() , this.inventoryService.getProductQuantity(orderItem.getProductEntity().getId()) - orderItem.getQuantity());
            }
        }
        log.warn(String.valueOf(areProductsAvailable));
        if(areProductsAvailable){
            toUpdateInventory.forEach((id, qty) -> this.inventoryService.updateInventory(qty,id));
            this.inventoryService.processOrder(data, KafkaConstants.KAFKA_TOPIC_ORDERS_PROCESSED);
        } else {
            this.inventoryService.processOrder(data, KafkaConstants.KAFKA_TOPIC_ORDERS_NOT_PROCESSED);
        }
    }
}
