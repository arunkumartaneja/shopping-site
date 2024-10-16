# shopping site




# Architecture Flow:
	
	Client Requests → API Gateway → Eureka Server → Microservices


+------------------+          +------------------+       +------------------+
|   Client (UI)    |  ----->  |   API Gateway     | ----> |   Microservice A  |
+------------------+          +------------------+       +------------------+
                                               |             (Registered with)
                                               |<------------>   Eureka Server
                                               v
                                         +------------------+
                                         |   Microservice B  |
                                         +------------------+

                                         
    Here is a simple flow chart:

```mermaid
graph TD;
     Client (UI)  --> API Gateway --> Eureka Server;
    Eureka Server--> Microservice A;
    Eureka Server--> Microservice B;
    Eureka Server--> Microservice C;
```
