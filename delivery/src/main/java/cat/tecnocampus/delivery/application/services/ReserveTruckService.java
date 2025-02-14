package cat.tecnocampus.delivery.application.services;

import cat.tecnocampus.delivery.application.ports.in.DeliveryCommand;
import cat.tecnocampus.delivery.application.ports.in.ReserveTruckUseCase;
import cat.tecnocampus.delivery.application.ports.out.DeliveryRepository;

import java.util.Optional;
import java.util.Random;

public class ReserveTruckService implements ReserveTruckUseCase {
    private final DeliveryRepository deliveryRepository;
    private final int truckAvailability;
    private final Random randomNumberGenerator = new Random();


    public ReserveTruckService(DeliveryRepository deliveryRepository, int truckAvailability) {
        this.deliveryRepository = deliveryRepository;
        this.truckAvailability = truckAvailability;
    }

    @Override
    public Optional<Delivery> reserveTruck(DeliveryCommand delivery) {
        try {
            throwErrorIfBadLuck(truckAvailability);
        }
        catch (RuntimeException e) {
            return Optional.empty();
        }

        Delivery newDelivery = new Delivery(delivery.orderId(), delivery.address(), delivery.customerName(), delivery.customerEmail());
        Delivery savedDelivery = deliveryRepository.save(newDelivery);
        return Optional.of(savedDelivery);
    }

    private void throwErrorIfBadLuck(int faultPercent) {
        if (faultPercent == 0) {
            return;
        }
        int randomThreshold = getRandomNumber(1, 100);
        if (faultPercent < randomThreshold) {
            System.out.println("We got lucky, no error occurred, %d < %d".formatted(faultPercent, randomThreshold));

        } else {
            System.out.println("Bad luck, an error occurred, %d >= %d".formatted(faultPercent, randomThreshold));
            throw new RuntimeException("Something went wrong...");
        }
    }

    private int getRandomNumber(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        return randomNumberGenerator.nextInt((max - min) + 1) + min;
    }
}
