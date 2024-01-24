# Show Reservations Manager

This project is a seat reservation system for shows. It uses Java Jakarta EE to create a REST API with CRUD (Create, Read, Update, Delete) operations for shows and associated reservations.
 
## Prerequisites

Make sure you have installed on your machine:
- Java Development Kit (JDK)
- Apache Maven
- Git

## Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/your-user/your-project.git
    ```

2. Navigate to the project directory:
    ```bash
    cd your-project
    ```

3. Compile and run the project:
    ```bash
    mvn clean install
    mvn tomee:run
    ```

The application will be accessible at [http://localhost:8080/your-project](http://localhost:8080/your-project).

## API Endpoints

### Shows
- **GET /shows :** List of all shows.
- **POST /shows :** Add a show.
- **GET /shows/{id} :** Details of a specific show.
- **PUT /shows/{id} :** Update a show.
- **DELETE /shows/{id} :** Delete a show.

### Reservations
- **GET /reservations :** List of all reservations.
- **GET /reservations/validated/{showId} :** Validated reservations for a show.
- **POST /reservations :** Add a reservation.
- **DELETE /reservations/{id} :** Delete a reservation.

## Contribute

To contribute:
1. Fork the repository.
2. Create a branch for your feature.
3. Commit your changes.
4. Push to the branch.
5. Create a new Pull Request.

## Technologies Utilisées

- **Jakarta EE:** Version 10.0.0
- **Servlet API:** Version 6.0.0
- **Jersey:** Version 3.1.1 (Jersey Container Servlet, Jersey HK2, Jersey Media JSON Jackson)
- **Jackson Module:** Version 2.14.2
- **Jakarta Activation API:** Version 2.1.2
- **Jakarta XML Bind API:** Version 4.0.0
- **JAXB API:** Version 2.3.1
- **JAXB Implementation (GlassFish):** Version 4.0.3
- **Hibernate:** Version 6.2.3.Final
- **PostgreSQL Driver:** Version 42.5.4

## Authors

Lucia Bourque

## License

This project is under the MIT License.
