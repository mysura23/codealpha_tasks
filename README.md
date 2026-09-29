# CodeAlpha DevOps Internship Tasks

**Name:** Mysura Reddy  
**Role:** DevOps Intern  
**Organization:** CodeAlpha  
**Repository Name:** `codealpha_tasks`  

---

## 🚀 Overview

This repository contains the completed hands-on DevOps tasks for the **CodeAlpha DevOps Internship program**. The repository is organized into distinct, modular project directories covering build automation, testing, CI/CD pipelines, containerization, and web server deployment.

---

## ✅ Completed Tasks

| Task | Title | Description | Technologies |
|---|---|---|---|
| **Task 3** | **Java Application using Gradle** | Automated build, JUnit testing, dependency management, and GitHub Actions CI/CD for a DevOps Task Tracker CLI app. | Java 17, Gradle 8.5, JUnit 5, GitHub Actions |
| **Task 4** | **Web Server using Docker** | Containerized Nginx web server serving custom static content, lifecycle management, and Docker Compose configuration. | Docker, Nginx, Docker Compose, HTML5/CSS3 |

---

## 🛠 Technologies Used

- **Programming & Scripting:** Java 17/21, Groovy (Gradle DSL), HTML5, CSS3, YAML
- **Build Automation & Testing:** Gradle 8.5, JUnit 5 Jupiter
- **CI/CD Pipeline:** GitHub Actions
- **Containerization & Deployment:** Docker, Docker Compose, Nginx (Alpine Linux)
- **Version Control:** Git, GitHub

---

## 📁 Repository Structure

```text
codealpha_tasks/
│
├── .github/
│   └── workflows/
│       └── java-gradle-ci.yml       # GitHub Actions CI/CD pipeline definition
│
├── task3-java-gradle/              # TASK 3: Java Application using Gradle
│   ├── src/
│   │   ├── main/
│   │   │   └── java/
│   │   │       └── com/codealpha/devops/
│   │   │           ├── Main.java          # Application entry point
│   │   │           ├── Task.java          # Data model
│   │   │           └── TaskManager.java   # Business logic
│   │   └── test/
│   │       └── java/
│   │           └── com/codealpha/devops/
│   │               └── TaskManagerTest.java # JUnit 5 test suite
│   ├── build.gradle                 # Gradle build configuration
│   ├── settings.gradle              # Project settings
│   ├── gradlew                      # Gradle wrapper script (Unix)
│   ├── gradlew.bat                  # Gradle wrapper script (Windows)
│   └── README.md                    # Detailed Task 3 documentation
│
├── task4-docker-webserver/         # TASK 4: Web Server using Docker
│   ├── Dockerfile                   # Docker container build script
│   ├── docker-compose.yml           # Multi-container orchestration definition
│   ├── index.html                   # Customized HTML web page
│   ├── nginx.conf                   # Custom Nginx web server configuration
│   └── README.md                    # Detailed Task 4 documentation
│
├── .gitignore                      # Git ignore rule specifications
└── README.md                       # Main repository overview documentation
```

---

## ⚙️ Quick Start & Execution Guide

### Task 3: Java Application using Gradle

Navigate to `task3-java-gradle`:
```bash
cd task3-java-gradle
```

1. **Clean build directory:**
   ```bash
   ./gradlew clean
   ```
2. **Build application:**
   ```bash
   ./gradlew build
   ```
3. **Execute unit tests:**
   ```bash
   ./gradlew test
   ```
4. **Run application:**
   ```bash
   ./gradlew run
   ```

---

### Task 4: Web Server using Docker

Navigate to `task4-docker-webserver`:
```bash
cd task4-docker-webserver
```

#### Option A: Using Docker CLI directly
1. **Build Docker image:**
   ```bash
   docker build -t codealpha-nginx .
   ```
2. **Run container on port 8080:**
   ```bash
   docker run -d --name codealpha-nginx -p 8080:80 codealpha-nginx
   ```
3. **Verify running container & logs:**
   ```bash
   docker ps
   docker logs codealpha-nginx
   ```
4. **Access in browser:**
   Open `http://localhost:8080`

#### Option B: Using Docker Compose
1. **Start web server:**
   ```bash
   docker compose up -d
   ```
2. **Stop web server:**
   ```bash
   docker compose down
   ```

---

## 🧠 Learning Outcomes

1. **Build Automation:** Mastered Gradle build lifecycle, dependency management, and custom task creation in Java development.
2. **Automated Testing:** Implemented clean unit tests with JUnit 5 and assertion verification.
3. **Continuous Integration (CI/CD):** Created GitHub Actions workflows to automate compilation, testing, and artifact generation on code push.
4. **Containerization:** Gained practical hands-on experience writing Dockerfiles, configuring Nginx web servers, handling port forwarding, container health checks, and orchestration with Docker Compose.
5. **DevOps Best Practices:** Adopted clean repository structure, strict `.gitignore` rules, modular documentation, and standardized execution steps.
