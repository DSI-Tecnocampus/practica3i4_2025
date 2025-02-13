package cat.tecnocampus.delivery.application.ports.in;

import cat.tecnocampus.delivery.application.services.Delivery;

import java.util.Optional;

public interface DeliveryUseCases {
    Optional<Delivery> reserveTruck(long deliveryId, int failOdds);
    void unreserveTruck(Delivery delivery);
    boolean cancelDelivery(long deliveryId);
}
