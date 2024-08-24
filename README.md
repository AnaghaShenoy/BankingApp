# Banking Application

## Overview
This Banking Application is a Java-based project that allows users to manage their bank accounts. The application provides functionalities such as creating accounts, managing balances, transferring funds, and viewing transaction history.

## Features
- **Account Management**: Create and manage bank accounts.
- **Balance Inquiry**: Check the current balance of an account.
- **Fund Transfer**: Transfer funds between accounts.
- **Transaction History**: View the history of transactions for a specific account.

## Technologies Used
- **Java**: Core language used for development.
- **Spring Boot**: Framework used to build the application.
- **Hibernate**: ORM framework for database interaction.
- **H2 Database**: In-memory database used for development and testing.
- **Maven**: Build automation tool.

## Project Structure
The project follows a layered architecture with the following structure:

- **Controllers**: Handle HTTP requests and map them to services.
- **Services**: Contain the business logic of the application.
- **Repositories**: Interact with the database to perform CRUD operations.
- **DTOs**: Data Transfer Objects used to transfer data between layers.
- **Entities**: Represent the database tables.

## Installation
To run this project locally:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/AnaghaShenoy/BankingApp.git
2. **Navigate to the project directory**:
   ```bash
   cd BankingApp
3. **Build the project using Maven**:
    ```bash
    mvn clean install
4. **Run the application**:
    ```bash
    mvn spring-boot:run

## Usage

Once the application is running, you can access the following endpoints:

- **Create Account**: `POST /accounts`
- **Get Account Details**: `GET /accounts/{accountNumber}`
- **Transfer Funds**: `POST /accounts/transfer`
- **View Transaction History**: `GET /accounts/{accountNumber}/transactions`


## Example API Calls

- **Create an Account:**
   ```bash
   curl -X POST http://localhost:8080/accounts -H "Content-Type: application/json" -d '{"accountHolderName": "John Doe", "balance": 1000.00}'
- **Get Account Details:**
   ```bash
   curl -X GET http://localhost:8080/accounts/1
- **Transfer Funds:**
   ```bash
   curl -X POST http://localhost:8080/accounts/transfer -H "Content-Type: application/json" -d '{"fromAccount": 1, "toAccount": 2, "amount": 100.00}'

## Contributing
Feel free to fork the repository and submit a pull request if you'd like to contribute to this project.

## Contact
For any questions or feedback, please contact: [anaghashenoyr@gmail.com](mailto:anaghashenoyr@gmail.com).

