# 🏥 Telemedicine Web APP / AI-Driven Public Health Chatbot for Disease Awareness
### *(AI in Healthcare | Sehat Sarthi Healthcare Telemedicine )*

![AI](https://img.shields.io/badge/AI-Healthcare-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Python](https://img.shields.io/badge/Python-3.12-yellow)
![Flask](https://img.shields.io/badge/Flask-Backend-black)
![Security](https://img.shields.io/badge/Security-JWT%20%7C%20BCrypt-red)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---

## 📌 Project Overview

The **AI-Driven Public Health Chatbot** is a **multilingual, AI-powered healthcare assistant** designed to educate and assist **rural and semi-urban populations** with preventive healthcare, disease awareness, vaccination guidance, and basic medical support.

This solution bridges the healthcare information gap using **Artificial Intelligence, NLP, and multimodal inputs (text, image, audio)** while supporting **low-internet and offline-first environments**.

---

## 🎯 Problem Statement

Access to reliable healthcare information remains limited in rural areas due to:
- Shortage of doctors and healthcare facilities
- Poor internet connectivity
- Low digital literacy
- Lack of awareness about diseases, vaccinations, and preventive care

This project addresses these challenges by providing **real-time, AI-assisted healthcare guidance** accessible to everyone.

---

## 💡 Key Features

### 🤖 AI Capabilities
- Multilingual conversational AI (local language support)
- AI-assisted symptom analysis (text-based)
- Medical image analysis (injuries, prescriptions, reports)
- Voice-to-text query support

### 🏥 Healthcare Services
- Disease awareness & preventive care education
- Vaccination schedules & outbreak alerts
- Nearby hospital & doctor discovery
- Digital appointment booking
- Medicine comparison & side-effect awareness
- Image-based first-aid guidance

### 🔐 Security & Privacy
- JWT-based authentication
- BCrypt password encryption
- Role-based access control
- Secure HTTPS communication

---

## 🧠 Innovation Highlights

- **Multimodal AI chatbot** (Text + Image + Audio)
- **Low-connectivity architecture** (offline-first design)
- **Government health API integration**
- **Scalable & modular microservices architecture**
- **AI-powered triage for early health guidance**

---

## 🏗️ System Architecture

### 🔹 Frontend
- Thymeleaf
- HTML5, CSS3, Bootstrap
- JavaScript (AJAX / Fetch API)

### 🔹 Backend
- Spring Boot
- Spring MVC & REST APIs
- Spring Security
- Spring Data JPA

### 🔹 AI Layer
- Python 3.12
- Flask microservices
- Google Gemini 2.0 Flash
- Speech Recognition APIs

### 🔹 Database
- MySQL / SQLite
- JPA & Hibernate ORM

### 🔹 Security
- JWT Authentication
- BCrypt Encryption
- HTTPS

---

## 📊 Expected Outcomes

| Metric | Target |
|------|-------|
| User Reach | 10,000+ users (pilot phase) |
| Accuracy | >80% symptom interpretation |
| Response Time | <3 seconds |
| Accessibility | Multi-language support |
| Adoption | Integration-ready with hospitals |

---

## 📅 Implementation Timeline ( – 3 Days)

| Phase | Duration | Deliverables |
|----|----|----|
| Research & Design | Day 1 | Problem validation, UI mockups |
| Core Development | Day 1 | Backend & frontend integration |
| AI Integration | Day 2 | Symptom & image analysis |
| Testing | Day 2 | Performance & security validation |
| Deployment | Day 2–3 | Local deployment & presentation |

---

## 🌍 Scalability & Societal Impact

### Scalability
- Horizontal scaling via regional language models
- Vertical scaling with additional healthcare modules
- API-first design for NGO & government integration

### Societal Impact
- Public health awareness & empowerment
- Rural healthcare accessibility
- Women & maternal health support
- Emergency & crisis response
- Digital health literacy promotion

---

**Collaboration Tools:** GitHub, Postman, Docker, Google Meet

---

## 🚀 Future Enhancements

- Integration with national digital health platforms
- WhatsApp & SMS healthcare alerts
- Wearable health data support
- AI-powered epidemic prediction
- Mobile app (Android / iOS)

---

# 📌 Spring Boot Backend Setup Guide (Eclipse + PostgreSQL)

This README helps you set up the backend & database environment for the project using **Eclipse IDE**, **Spring Boot**, and **PostgreSQL**.

---

## 📥 Step 1: Download the GitHub Project

1. Open **GitHub Repository**
2. Click **Code → Download ZIP**
3. Extract the ZIP file (your project folder will appear)

---

## ☕ Step 2: Install JDK

Install **JDK 21** or **JDK 24**

### ✔️ Verify Installation

Open **CMD** and run:

```
java -version
```

Make sure **JAVA_HOME** is properly set.

---

## 🖥️ Step 3: Install Eclipse IDE

Download **Eclipse IDE for Java Developers**

> ⚠️ Note: "Eclipse Installer" version is **Eclipse IDE for Enterprise Java and Web**

Install & open Eclipse.

---

## 🔧 Step 4: Install Spring Tools (STS) Plugin in Eclipse

1. In Eclipse: **Help → Eclipse Marketplace...**
2. Search **Spring Tools 4**
3. Install → Restart Eclipse

This adds:

* Run As → Spring Boot App
* Spring Boot Dashboard
* Better Spring project support

---

## 📂 Step 5: Import the Spring Boot Project

1. Open Eclipse → **File → Import**
2. Select **Existing Maven Project**
3. Browse & select your extracted project folder
4. Click **Finish**

---

## 🔧 Step 6: Resolve Maven Dependencies

1. Right‑click project → **Maven → Update Project (Alt+F5)**
2. Keep internet ON to download all dependencies

---

## ⚙️ Step 7: Run the Spring Boot Application

1. Go to **src/main/java**
2. Find the class with `@SpringBootApplication`
3. Right‑click → **Run As → Spring Boot App**

---

## 🛢️ Step 8: Install PostgreSQL + pgAdmin

Download & install:

* **PostgreSQL Database Server**
* **pgAdmin** (GUI to manage DB)

Configure your DB credentials in `application.properties` or `application.yml`:

```
server.port=8080 // change accoding to you 

spring.datasource.url=jdbc:postgresql://localhost:5431/ipintelligence_db  // change accoding to you 
spring.datasource.username=postgres
spring.datasource.password=shanu03  // change accoding to you 

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.format_sql=true

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

---

## 6. Design Diagrams

Here is the ER Diagram for the database structure:



## 🚀 DONE! Your Backend Environment Is Ready 🎉

You can now begin development, testing, and API integration.

---

## 📎 Additional Commands

### Clean & Build Project

```
mvn clean install
```

### Run Spring Boot via terminal

```
mvn spring-boot:run
```

---

## 🤝 Contributing

1. Fork the repo
2. Create a feature branch
3. Commit your changes
4. Push & create a Pull Request

---

## 📬 Contact

If you face any issue, feel free to raise an **Issue** in the GitHub repo.
