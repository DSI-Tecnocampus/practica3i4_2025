package cat.tecnocampus.delivery.application.ports.in;

public interface SendDeliveryUseCase {
    boolean sendDelivery(long deliveryId);
}
