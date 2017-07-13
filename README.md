# Mock Trade Booking System using Spring Boot REST.

### Requirements

- Maven
- JDK 8

### Running

To build and start the server simply type

```sh
$ mvn spring-boot:run
```
or
```sh
java -jar -Dserver.port=8080 target/tbooking-0.0.1-SNAPSHOT.jar 0.7 20
```

```sh
usage: java -jar [-Dserver.port=8080] JARFILE [probabilityOfFailure (0.0-1.0)]  numberOfInitialTrades
```
from the root directory.

### Using

You can see what urls are available using curl:

```sh
$ curl localhost:8080
```

You can view original trade objects using this request:

```sh
$ curl localhost:8080/trades
```

and can create new ones using a POST:

```sh
$ curl -X POST -H "Content-Type:application/json" -d '{ "price" : 99.0, "quantity" : 20.0, "instrument" : "bond1", "firmAccount" : "1234",  "counterParty"  : "Cust1" }' localhost:8080/trades
```

You can view booked trade objects with this request. These are similar to the original trades but have an additional trade state field which has a random value of success or failed based on the probabiliityOfFailure parameter:

```sh
$ curl localhost:8080/bookedTrades
```
### Todo

 - add search api
 - Web page to post new trades
 - Writing tests


# tbooking
