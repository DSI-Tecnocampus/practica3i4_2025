package cat.tecnocampus.delivery.adapters.out;

import cat.tecnocampus.delivery.application.services.Delivery;

import java.util.Optional;

public class DeliveryRepository implements cat.tecnocampus.delivery.application.ports.out.DeliveryRepository {
    private final DeliveryRepositoryJPA deliveryRepositoryJPA;

    public DeliveryRepository(DeliveryRepositoryJPA deliveryRepositoryJPA) {
        this.deliveryRepositoryJPA = deliveryRepositoryJPA;
    }

    public Delivery save(Delivery delivery) {
        var entity = deliveryRepositoryJPA.save(DeliveryMapper.toEntity(delivery));
        return DeliveryMapper.toModel(entity);
    }

    public void updateDeliveryStatus(long deliveryId, cat.tecnocampus.delivery.application.services.Delivery.Status status) {
        deliveryRepositoryJPA.updateDeliveryStatus(deliveryId, DeliveryEntity.Status.valueOf(status.name()));
    }

    public Optional<Delivery> findById(long deliveryId) {
        return deliveryRepositoryJPA.findById(deliveryId).map(DeliveryMapper::toModel);
    }
}
