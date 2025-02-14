package cat.tecnocampus.delivery.adapters.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DeliveryRepositoryJPA extends JpaRepository<DeliveryEntity, Long> {
    Optional<DeliveryEntity> findById(long deliveryId);

    @Query("UPDATE DeliveryEntity d SET d.status = :status WHERE d.id = :deliveryId")
    void updateDeliveryStatus(long deliveryId, DeliveryEntity.Status status);
}
