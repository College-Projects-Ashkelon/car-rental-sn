# car-rental-sn

#Sergey & Niv
\# 🚗 Car Rental System



An object-oriented Java application designed to manage car rental operations, user registrations, logins, and fleet inventory management.



\---



\## 📌 Project Overview

This project simulates a backend domain model and CLI interaction for a Car Rental System. It supports multi-role interactions for \*\*Rental Agents\*\* and \*\*Customers\*\*, enforcing system constraints and data validation.



\---



\## 🚀 Implemented Features \& Epics



\### 🟢 Epics \& User Stories

\* \*\*KAN-333: Foundation \& Domain Models\*\*

&#x20; \* `User`: Manages user credentials, role limits (Agents: up to 10 cars, Customers: up to 3 cars), and password validation.

&#x20; \* `Location`: Pre-populated with 10 official rental locations across Israel.

&#x20; \* `Car`: Represents vehicle properties, owner, location, and daily rates.

&#x20; \* `RentalSystem`: Central controller managing data arrays and system initialization.



\* \*\*KAN-345: \[REQ-001] User Registration\*\*

&#x20; \* Unique username enforcement (Case-insensitive).

&#x20; \* Strong password validation (Requires at least 1 digit and 1 special character: `$`, `%`, `\_`).

&#x20; \* Driver's license format validation (Exactly 8 digits).

&#x20; \* Account role allocation (`Agent` vs. `Customer`).



\---



\## 🛠️ Project Structure



```text

src/

├── Car.java            # Vehicle domain model

├── Location.java       # Branch location model

├── User.java           # User profile \& authentication logic

├── RentalSystem.java   # System controller \& business logic

└── Main.java           # Integration tests \& E2E runner





