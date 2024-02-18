package inventory.inventorykafka.services.impl;

import inventory.inventorykafka.repositories.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import inventory.inventorykafka.dtos.OrderDTO;
import inventory.inventorykafka.entities.InventoryEntity;
import inventory.inventorykafka.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private KafkaTemplate<String, OrderDTO> kafkaTemplate;

    @Override
    public boolean isInventoryAndAvailableQuantity(long id, int qty) {
        InventoryEntity inventoryEntity = this.inventoryRepository.findByIdAndAvailableQuantityGreaterThanEqual(id,qty);
         if(Objects.isNull(inventoryEntity)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void updateInventory(Integer qty, Long id) {
        this.inventoryRepository.updateInventoryById(qty,id);
    }

    @Override
    public void processOrder(OrderDTO orderDTO, String topicName) {
        log.debug(topicName + " : processOrder with " + orderDTO.toString());
        this.kafkaTemplate.send(topicName, orderDTO);
    }

    @Override
    public Integer getProductQuantity(Long id) {
       return this.inventoryRepository.getInventoryEntityById(id).getAvailableQuantity();
    }
}
