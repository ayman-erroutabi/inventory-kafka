package inventory.inventorykafka.repositories;

import inventory.inventorykafka.entities.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity,Long> {

    InventoryEntity findByIdAndAvailableQuantityGreaterThanEqual(long id, int qty);

    @Modifying
    @Query("update InventoryEntity inv set inv.availableQuantity = ?1 where inv.id = ?2")
    void updateInventoryById(Integer qty, Long productId);

    InventoryEntity getInventoryEntityById(Long id);
}
