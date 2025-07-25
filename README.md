Backend automation tests for https://restcountries.com 

# Rest Countries API Test Suite

This project is a **REST API test automation framework** built using **Java**, **TestNG**, **Rest Assured**, and **Allure Reports**. It validates the functionality and schema of the [REST Countries API](https://restcountries.com/), including custom assertions such as checking if **South African Sign Language** is recognized.

---

## 📌 Features

- Validate country data response schema
- Count and verify the total number of countries
- Check for specific languages like **South African Sign Language (SASL)**
- Designed using **TestNG** for test structure and assertions
- REST API requests built with **Rest Assured**
- Integrated with **Allure Reports** for enhanced test reporting

---

## 📁 Project Structure

Rest_Countries_Test/
├── pom.xml
├── README.md
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── country_PayloadBuilder/
│ │ │ └── RestCountrySchemaPayloadBuilder.java
│ │ └── country_RequestBuilder/
│ │ └── RestCountryRequestBuilder.java
│ └── test/
│ └── java/
│ └── tests/
│ └── TestCountry.java
└── resources/
└── schema/
└── countries_schema.json


---

## 🛠️ Technologies Used

- Java 17
- Maven
- Rest Assured
- TestNG
- Allure Reports
- JSON Schema Validator

---

## 🚀 Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 17+
- Maven 
- IntelliJ IDEA

---

### 🧾 Installation & Setup

1. **Clone the repository**:
   ```bash
   git clone https:https://github.com/AthenkosiAfikile/Rest_Countries_api_tests
   cd Rest_Countries_api_tests



