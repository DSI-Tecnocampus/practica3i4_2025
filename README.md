# Practical Exercise 3 and 4. Microservices

## Exercise 1
+ Implement the microservices: Customer, Product, Order, and OrderHistory. Note that the Delivery service is already implemented. 
+ Implement the Create Order SAGA using a request/response synchronous pattern.
     1. The Order service receives a request to create an order
     2. The Order service sends a request to the Product service to reserve the products
     2. The Order service sends a request to the Delivery service to deliver the order (POST /deliveries that calls the Reserve Truck operation)
     3. The Order service updates the status of the order to "Finished"
     4. The Order service sends an event to the OrderHistory service to store the order
     5. If any of the previous steps fails, the Order service executes the appropriate compensating transactions

## Exercise 2
Implement the Cancel Order SAGA, where the order service asks the Delivery service to cancel the delivery. The cancellation of the Delivery 
is only possible if it hasn't been sent yet. If successful, 
the order is canceled and an event is sent. The rest of the services should react to the event:
+ Customer service: Refund the payment
+ Product service: Increase the stock
+ OrderHistory service: Update the status of the order

## Extra points
Implement infrastructure patterns 
+ Discovery Service and load balancing
+ API Gateway
+ Circuit Breaker
+ Distributed Tracing