package cat.tecnocampus.delivery.application.ports.out;

import cat.tecnocampus.delivery.application.services.Delivery;

public interface DeliveryRepository {
    Delivery save(Delivery delivery);
    void updateDeliveryStatus(long deliveryId, Delivery.Status status);
}
