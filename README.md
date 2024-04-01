# 🛒 Shopping Web App

This is a simple shopping web application developed using Java and Spring Framework. Users can perform various actions such as ordering products, applying coupons, making payments, and viewing order statuses. Below are the details of the features and technologies used in this project.

## Features

🛍️ Enter Quantity: Users can enter the quantity of products they want to order.

🔍 Check Availability: The app checks if the desired quantity of the product is available.

💳 Apply Coupons: Users can check available coupons and apply one if valid. A coupon can only be applied once per user.

💸 Make Payment: Users can make payment for their orders securely.

📝 View Order Status: Users can view the status of all their orders.

## Technology Stack

### Backend

- **Java**: Core language used for backend development.
- **Spring Framework**: Used for building the application, including Spring MVC for handling web requests.
- **JPA (Java Persistence API)**: Used for managing relational data in the application.
- **Hibernate**: ORM (Object-Relational Mapping) framework used for mapping Java objects to database tables.
- **Lombok**: Library used to reduce boilerplate code in Java classes.

### Frontend

- **HTML**: Used for structuring the web pages.
- **CSS**: Used for styling the web pages.
- **JavaScript**: Used for client-side scripting.
- **Thymeleaf**: Server-side Java template engine used for rendering views.

### Database

- **MySQL**: Relational database management system used for storing application data.

## Setup Instructions

1. Clone the repository: `git clone <repository-url>`
2. Navigate to the project directory: `cd shopping-web-app`
3. Set up MySQL database and update database configurations in `application.properties` file.
4. Build the project using Maven: `mvn clean install`
5. Run the application: `java -jar target/shopping-web-app.jar`
6. Access the application in your web browser at `http://localhost:8080`

Feel free to explore and modify the application according to your requirements!

🎉 Happy Shopping! 🎉
