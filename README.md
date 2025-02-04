# shopping site

# Important links
- https://kafka.apache.org/quickstart
- https://zipkin.io/pages/quickstart.html


# Architecture Flow:
	
	Client Requests → API Gateway → Eureka Server → Microservices

                                         
    Here is a simple flow chart:



```mermaid
graph TD;
    subgraph Client
        C[Client]
    end
    
    subgraph Gateway
        API[API Gateway]
    end

    subgraph Discovery
        E[Eureka Server]
    end

    subgraph Caching
        Redis[Redis Cache]
    end

    subgraph Messaging
        Kafka[Kafka Messaging Queue]
    end
    
    subgraph Services
        User[User Service]
        Order[Order Service]
        Inventory[Inventory Service]
        Payment[Payment Service]
        Notification[Notification Service]
    end
    
    C --> API
    API --> E
    E --> User
    E --> Order
    E --> Inventory
    E --> Payment
    E --> Notification
    
    API --> Redis
    Redis --> Inventory

    Order -->|Fetch| Inventory
    Order -->|Update| Payment
    Payment -->|Notify| Notification
    Order -->|Notify| Notification
    Inventory -->|Update| Notification
    
    Order -->|Publish| Kafka
    Inventory -->|Consume| Kafka
    Notification -->|Consume| Kafka
    
    Redis -->|Cache| API
```

# Explanation of the Flow:
- Client (C) sends requests to the API Gateway (API), which serves as the entry point.
- API Gateway communicates with the Eureka Server (E) for service discovery to route requests to the appropriate services.
- Redis Cache (Redis) is used to cache frequently accessed data, such as product information.
Services interact with each other:
- Order Service interacts with Inventory Service to fetch product availability.
- Payment Service handles payment processing for an order.
- Notification Service sends notifications after certain actions (e.g., order placement, payment confirmation).
- Kafka is used as a messaging queue to facilitate communication between services.
- Redis Cache provides a caching layer to improve performance.
