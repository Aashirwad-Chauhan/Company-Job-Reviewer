
# Spring Boot Practice Project

This is a simple backend project built with Spring Boot. It demonstrates the use of JPA for data persistence and H2 as the in-memory database. The project is designed to be a practice exercise, allowing users to list companies, jobs, and reviews, with all entities interconnected through references in the database.

## Features

- List all companies, jobs, and reviews
- Search by ID for companies, jobs, and reviews
- Add new companies, jobs, and reviews
- Update existing companies, jobs, and reviews
- Delete companies, jobs, and reviews
- Actuators for monitoring and maintenance

## Project Structure

The project follows the Model-View-Controller (MVC) architecture to ensure scalability and loose coupling of components.

## Technologies Used

- Spring Boot
- Spring Data JPA
- H2 Database
- Spring Boot Actuator

## Endpoints
- I have commented the endpoint exposed in the application properties file, you can configure it.

### Company Endpoints

- **List all companies**: `GET /companies`
- **Search company by ID**: `GET /companies/{id}`
- **Add a new company**: `POST /companies`
- **Update an existing company**: `PUT /companies/{id}`
- **Delete a company**: `DELETE /companies/{id}`

### Job Endpoints

- **List all jobs**: `GET /jobs`
- **Search job by ID**: `GET /jobs/{id}`
- **Add a new job**: `POST /jobs`
- **Update an existing job**: `PUT /jobs/{id}`
- **Delete a job**: `DELETE /jobs/{id}`

### Review Endpoints

- **List all reviews**: `GET /company/reviews`
- **Search review by ID**: `GET /company/reviews/{id}`
- **Add a new review**: `POST /company/reviews`
- **Update an existing review**: `PUT /company/reviews/{id}`
- **Delete a review**: `DELETE /company/reviews/{id}`

## How to Run
- Tools
    - Java Setup
    - IntelliJ/Visual Studio 
    - For Creating Maven Project
        ```
        https://start.spring.io/
        ```
    -PostMan (For Hitting API endpoints)    

- Clone the repository:
    ```bash
    git clone https://github.com/yourusername/your-repo-name.git
    ```

- Navigate to the project directory:
    ```bash
    cd your-repo-name
    ```

- Build the project:


- Run the application:

- Access the H2 database console:
    ```
    http://localhost:8080/h2-console
    ```
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User Name: `sa`
   - Password: (leave blank)

- PostMan Documentation for API endpoints
    ```
    https://documenter.getpostman.com/view/33496904/2sA3duFYq8
    ```

## Actuators

The project includes Spring Boot Actuator for monitoring and managing the application. You can access various endpoints such as health, metrics, and info.

- **Health Check**: `GET /actuator/health`
- **Metrics**: `GET /actuator/metrics`
- **Info**: `GET /actuator/info`

## Contributing

If you'd like to contribute to this project, please fork the repository and create a pull request with your changes. Make sure to include a detailed description of your changes.




