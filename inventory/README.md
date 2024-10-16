

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
    A-->B;
    A-->C;
    B-->D;
    C-->D;
```