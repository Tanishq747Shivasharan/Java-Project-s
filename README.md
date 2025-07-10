# State-Board Electricity Management System.

## Introduction
The Electricity Management System is a Java-based application developed to automate and simplify the process of electricity billing and customer data management. This system enables users to input customer details, perform bill calculations based on usage, and generate payment information dynamically.

One of the key features of this system is its integration with a database, allowing for efficient storage and retrieval of customer records and billing history. This ensures data consistency, easy access to historical information, and better management of billing operations.

Designed for utility service providers or educational purposes, the system aims to reduce manual work, minimize errors, and offer a user-friendly menu-driven interface for handling electricity billing tasks.

## Table of Contents
- [About](#about)
- [Features](#features)
- [Project Structure](#project)
- [Installation](#installation)
- [Usage](#usage)
- [Screenshots](#Screenshots)
- [Prerequisites](#prerequisites)

## About
Electricity Management System is a Java-based application designed to streamline electricity billing and customer management. The system allows users to input customer details, calculate bills, and display payment information. It also includes functionality for storing user data in a database and retrieving stored records for review. This project helps automate the billing process and maintain organized records for utility service providers or simulation-based use cases.

## Features
1. This simple Java applicatio is designed to dynamically take user inputs making it user-friendly and easy to use.
2. It has got simple menu-driven based design with options which are coded to perform some specific task.
3. It takes **Customer details**,**Billing information** and **Payment details**.
4. The **Billing system** calcuates the bill and displayes to user and, tells how many to pay to the users and based on the given bill the user is displayed with the filnal payed or not payed(due) status of **Bill payment**.
5. After the data has been taken from the user the data is automatically stored in the database created..**(NOTE: The database should be created or else an error message is displayed)**
6. The users can also view the data stored in the database in the output window.

## Project Structure
```
📁 electricity-management
│
├── 📁 src
│ ├── 📁 main
│ │ ├── 📁 java
│ │ │ └── 📁 org
│ │ │ └── 📁 electricitymanagement
│ │ │ ├── 📁 DatabaseGuide
│ │ │ ├── ☕ Bill.java
│ │ │ ├── ☕ Customer.java
│ │ │ ├── ☕ DB.java
│ │ │ ├── ☕ DBView.java
│ │ │ ├── ☕ Main.java
│ │ │ ├── ☕ Payment.java
│ └── 📁 test
│ ├── 📁 java
│ │ └── 📁 org
│ │ └── 📁 electricitymanagement
│ │ └── ☕ AppTest.java
│
├── 📁 target
│ ├── 📁 classes
│ │ └── 📁 org
│ │ └── 📁 electricitymanagement
│ │ ├── 📁 DatabaseGuide
│ │ ├── 📄 Bill.class
│ │ ├── 📄 Customer.class
│ │ ├── 📄 DB.class
│ │ ├── 📄 DBView.class
│ │ ├── 📄 Main.class
│ │ ├── 📄 Payment.class
│ ├── 📁 generated-sources
│ │ └── 📁 annotations
│ ├── 📁 maven-status
│ │ └── 📁 maven-compiler-plugin
│ │ └── 📁 compile
│ │ └── 📁 default-compile
│ │ ├── 📄 createdFiles.lst
│ │ └── 📄 inputFiles.lst
│ └── 📁 test-classes
│ └── 📁 org
│ └── 📁 electricitymanagement
│ └── 📄 AppTest.class
│
├── 🌐 pom.xml
```

## Installation
```markdown
# Clone the repositoty
git clone https://github.com/Tanishq747Shivasharan/Java-Project-s

# Navigate into the directory
cd Java-Project-s

# Install dependencies
npm install
```

## Usage

Once the project is installed and compiled, you can run the application and interact with it through the console.

### Steps to Use:

1. **Launch the application:**

   ```bash
   java -cp target/classes org.electricitymanagement.Main
   ```

2. **Follow on-screen prompts:**
   - Enter customer details (Name, Meter Number, Units Consumed, etc.)
   - The system will calculate the bill based on the input
   - Displays payment details (amount due, taxes, etc.)

3. **Database operations:**
   - Customer and billing information is stored in the connected database
   - You can view stored records using in-app options (via `DBView.java`)

### Notes:

- Make sure your database is running and properly configured in `DB.java` or `config.properties`.
- You can view stored data using:
  ```bash
  java -cp target/classes org.electricitymanagement.DBView
  ```

## Screenshots

### Full Console Ouput
![Console Output](https://github.com/Tanishq747Shivasharan/Java-Project-s/blob/main/images/Screenshot%202025-07-09%20225039.png)
![Console Output](https://github.com/Tanishq747Shivasharan/Java-Project-s/blob/main/images/Screenshot%202025-07-09%20225221.png)
![Console Output](https://github.com/Tanishq747Shivasharan/Java-Project-s/blob/main/images/Screenshot%202025-07-09%20225316.png)
![Console Output](https://github.com/Tanishq747Shivasharan/Java-Project-s/blob/main/images/Screenshot%202025-07-09%20225409.png)
![Console Output](https://github.com/Tanishq747Shivasharan/Java-Project-s/blob/main/images/Screenshot%202025-07-09%20225452.png)

## Prerequisites

- Java JDK 17 or later
- PostgreSQL or any supported relational database
- A Java IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)
- Apache Maven installed ![Download link](https://maven.apache.org/install.html?utm_source=chatgpt.com)


