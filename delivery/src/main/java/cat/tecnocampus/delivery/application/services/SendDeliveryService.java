package cat.tecnocampus.delivery.application.services;

import cat.tecnocampus.delivery.application.ports.in.SendDeliveryUseCase;
import cat.tecnocampus.delivery.application.ports.out.DeliveryRepository;

public class SendDeliveryService implements SendDeliveryUseCase {
    private final DeliveryRepository deliveryRepository;


    public SendDeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public boolean sendDelivery(long deliveryId) {
        var delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new RuntimeException("Delivery with id "+ deliveryId +" not found"));
        if (delivery.getStatus() != Delivery.Status.IN_PREPARATION) {
            return false;
        }
        deliveryRepository.updateDeliveryStatus(deliveryId, Delivery.Status.SENT);
        return true;
    }
}
