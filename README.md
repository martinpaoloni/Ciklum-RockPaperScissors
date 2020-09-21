# Rock, Paper, Scissors

This project contains a solution to the coding challenge provided by [Ciklum](https://www.ciklum.com/), for my application to [Lottoland](https://www.lottolandcorporate.com/).

The description of this challenge can be found inside the `doc/` directory.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for testing purposes.

### Prerequisites

- Java 8

That's it! The project contains embedded Maven binaries, so nothing else should be necessary.

### Running the application

You can run the application by executing the following command:

```
mvnw spring-boot:run
```

Add `./` to the previous command if running macOS or Linux. You may need to do a `chmod +x mvnw` in order to make it executable.

After doing so, open a web broswer and point it to http://localhost:8080/ to play _Rock, Paper, Scissors_ games!

You can open as many tabs as you want. Each one will start a separate game.

You will also find general game statistics at http://localhost:8080/stats.

## Running the tests

As this is a Maven project, tests will run by executing `mvnw clean install`.

## Built With

* [Java 8](https://openjdk.java.net/) - My backend language of choice
* [Spring Boot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [JQuery](https://jquery.com/) - For DOM manipulation and Ajax calls
* [Bootstrap](https://getbootstrap.com/) - CSS framework

## Author

* **Martín Paoloni** - [GitHub profile](https://github.com/martinpaoloni)

