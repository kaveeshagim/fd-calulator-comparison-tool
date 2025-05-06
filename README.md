# 💰 Fixed Deposit Calculator & Comparison Tool

A simple web app built with **Java**, **Spring Boot**, **Thymeleaf**, and **H2** (in-memory DB) that helps users calculate and compare Fixed Deposit (FD) maturity amounts based on initial deposit, interest rate, duration, and renewable option.

---

## ✨ Features

- Input FD details (amount, rate, duration, renewable)
- Calculate maturity amount using compound/simple interest
- Real-time results displayed using Thymeleaf
- No persistent database — H2 is used for lightweight, temporary data
- Fully beginner-friendly and easy to extend!

## 🛠️ Tech Stack

- **Backend**: Java 22, Spring Boot 3+
- **Frontend**: Thymeleaf templating engine
- **Database**: H2 (in-memory)
- **Build Tool**: Maven

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/fd-calculator.git
   cd fd-calculator
   ```
2. Run the project:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Open the browser:
   ```bash
   http://localhost:8080
   ```

## 📷 UI Preview

## 🧠 Learnings

This project helped me:

- Understand Spring Boot basics
- Use Thymeleaf for server-side HTML rendering
- Practice Java service/controller/model design
- Implement financial logic with compound interest
