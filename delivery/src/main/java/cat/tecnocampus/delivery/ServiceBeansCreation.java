package cat.tecnocampus.delivery;

import cat.tecnocampus.delivery.application.ports.in.CancelDeliveryUseCase;
import cat.tecnocampus.delivery.application.ports.in.ReserveTruckUseCase;
import cat.tecnocampus.delivery.application.ports.out.DeliveryRepository;
import cat.tecnocampus.delivery.application.services.CancelDeliveryService;
import cat.tecnocampus.delivery.application.services.ReserveTruckService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeansCreation {

    private final DeliveryRepository deliveryRepository;
    private final int truckAvailability;

    public ServiceBeansCreation(DeliveryRepository deliveryRepository, @Value("${delivery.truck.availability}") int truckAvailability) {
        this.deliveryRepository = deliveryRepository;
        this.truckAvailability = truckAvailability;
    }

    @Bean
    public ReserveTruckUseCase reserveTruckUseCase() {
        return new ReserveTruckService(deliveryRepository, truckAvailability);
    }

    @Bean
    public CancelDeliveryUseCase cancelDeliveryUseCase() {
        return new CancelDeliveryService(deliveryRepository);
    }
}
