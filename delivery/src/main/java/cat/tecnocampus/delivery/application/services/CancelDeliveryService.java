package cat.tecnocampus.delivery.application.services;

import cat.tecnocampus.delivery.application.ports.in.CancelDeliveryUseCase;
import cat.tecnocampus.delivery.application.ports.out.DeliveryRepository;

public class CancelDeliveryService implements CancelDeliveryUseCase {
    private final DeliveryRepository deliveryRepository;

    public CancelDeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public boolean cancelDelivery(long deliveryId) {
        var delivery = deliveryRepository.findById(deliveryId);
        if (delivery.isEmpty() || delivery.get().getStatus() != Delivery.Status.IN_PREPARATION) {
            return false;
        }
        deliveryRepository.updateDeliveryStatus(deliveryId, Delivery.Status.CANCELED);
        return true;
    }
}
