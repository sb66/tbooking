# Spring Boot REST interface for Trade Booking

### Requirements

- Maven
- JDK 8

### Running

To build and start the server simply type

```sh
$ mvn spring-boot:run
```

from the root directory.

### Using

You can see what urls are available using curl:

```sh
$ curl localhost:8080
```

You can view existing people objects using a similar request:

```sh
$ curl localhost:8080/trades
```

and can create new ones using a POST:

```sh
$ curl -X POST -H "Content-Type:application/json" -d '{ "price" : 99.0, "quantity" : 20.0, "instrument" : "bond1", "firmAccount" : "1234",  "counterParty"  : "Cust1" }' localhost:8080/trades
```

### Todo

 - add search api
 - Web page to post new trades
 - Writing tests


# tbooking
