package cat.tecnocampus.delivery.application.ports.in;

import cat.tecnocampus.delivery.application.services.Delivery;

import java.util.Optional;

public interface ReserveTruckUseCase {
    Optional<Delivery> reserveTruck(DeliveryCommand delivery);
}
