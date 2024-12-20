# Chat Application

## Overview

This is a Java-based chat application that utilizes several design patterns to ensure a robust, scalable, and maintainable architecture. The application is organized into distinct packages, each responsible for specific functionalities, ranging from data access to user interface management.

## Features

- User authentication and registration  
- Real-time messaging between users and groups  
- Group management (create, update, delete, and manage memberships)  
- Contact management (add, edit, delete contacts)  
- Support for text, image, and video messages  

## Design Patterns Used

- **Model-View-Controller (MVC)**: Separates the application into three interconnected components to separate internal representations of information from the ways that information is presented and accepted by the user.  
- **Data Access Object (DAO)**: Provides an abstract interface to some type of database or other persistence mechanism.  
- **Singleton**: Ensures a class has only one instance and provides a global point of access to it.  
- **Factory**: Creates objects without specifying the exact class of object that will be created.  
- **Observer**: Allows objects to be notified of changes in other objects.  
- **Proxy**: Provides a surrogate or placeholder for another object to control access to it.  

## Project Structure

- **controller**: Contains classes that manage the core operations of the application, acting as the business logic layer.  
- **dao**: Provides data access objects that handle interactions with the database.  
- **factory**: Uses the Factory Design Pattern to encapsulate the creation logic for messages and groups.  
- **model**: Defines the core data structures used throughout the application.  
- **observer**: Implements the Observer Design Pattern for real-time updates.  
- **proxy**: Implements the Proxy Design Pattern for controlled access to message sending.  
- **util**: Provides utility functions, specifically for database connectivity.  
- **view**: Manages the graphical user interface components of the application.  

## Setup and Installation

1. **Clone the repository**:  
   ```bash
   git clone https://github.com/am94an/chat-application.git
   ```

2. **Navigate to the project directory**:  
   ```bash
   cd chat-application
   ```

3. **Ensure you have Java and a compatible IDE (like Netbeans or IntelliJ IDEA) installed.**

4. **Set up the database**:  
   - Ensure you have MySQL installed and running.  
   - Create a database named `chatapplication`.  
   - Import the database schema and data from the provided SQL file.  

5. **Configure database connection**:  
   - Update the `Database` class in the `util` package with your database credentials.  

6. **Run the application**:  
   - Open the project in your IDE.  
   - Run the main class to start the application.  

## Usage

- **Login**: Use your credentials to log in.  
- **Sign Up**: Register a new account if you don't have one.  
- **Chat**: Start chatting with other users or groups.  
- **Manage Contacts and Groups**: Add, edit, or delete contacts and groups as needed.  

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.  

## License

This project is licensed under the MIT License. See the LICENSE file for details.  

## Contact

For any questions or feedback, please contact `hossamaman9@gmail.com`.  

