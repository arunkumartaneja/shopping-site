# shopping site




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
