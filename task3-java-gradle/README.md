# Task 3: Java Application using Gradle

**CodeAlpha DevOps Internship**  
**Author:** Mysura Reddy  
**Project:** DevOps Task Tracker  
**Tech Stack:** Java 17 / 21, Gradle 8.5, JUnit 5, GitHub Actions CI/CD  

---

## 📌 Project Overview

This project is a clean, professional, pure Java console application named **DevOps Task Tracker**, built to demonstrate modern Java build automation, dependency management, unit testing, and CI/CD pipeline integration using **Gradle** and **GitHub Actions**.

It intentional avoids heavy frameworks like Spring Boot to keep the application lightweight, fast, and easy to understand for DevOps build automation fundamentals.

---

## 🛠 Features

- **Add DevOps Tasks:** Register new tasks with auto-incremented IDs, titles, and categories (Build, Testing, CI/CD, Docker, etc.).
- **List All Tasks:** Display active tasks formatted with status indicators (`[PENDING]` / `[COMPLETED]`) and timestamps.
- **Mark Task as Completed:** Update task status dynamically by task ID.
- **Task Summary & Metrics:** View overall metrics (Total Tasks, Completed Count, Pending Count).
- **Automated Unit Testing:** Test suite implemented using JUnit 5.

---

## 📁 Directory & File Structure

```text
task3-java-gradle/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── codealpha/
│   │               └── devops/
│   │                   ├── Main.java          # CLI Application Entry Point
│   │                   ├── Task.java          # Task Data Model
│   │                   └── TaskManager.java   # Business Logic & Management
│   └── test/
│       └── java/
│           └── com/
│               └── codealpha/
│                   └── devops/
│                       └── TaskManagerTest.java # JUnit 5 Unit Tests
├── build.gradle         # Gradle Build Script & Dependencies
├── settings.gradle      # Project Name & Settings
├── gradlew              # Unix Gradle Wrapper Script
├── gradlew.bat          # Windows Gradle Wrapper Script
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
└── README.md            # Task Documentation
```

---

## ⚙️ Gradle Build Configuration

### `settings.gradle`
Defines the root project name:
```groovy
rootProject.name = 'devops-task-tracker'
```

### `build.gradle` Highlights
- **Plugins:** Standard `java` and `application` plugins.
- **Target Java Version:** Java 17.
- **Dependencies:** JUnit 5 (`org.junit.jupiter:junit-jupiter-api:5.10.2` & `junit-jupiter-engine:5.10.2`).
- **Main Class:** `com.codealpha.devops.Main`.
- **Custom Task:** `appInfo` to display application metadata.

---

## 🚀 How to Run the Application Locally

Run all commands from the `task3-java-gradle/` directory:

### 1. Clean Previous Builds
```bash
./gradlew clean
```

### 2. Compile & Build the Project
```bash
./gradlew build
```

### 3. Run JUnit 5 Tests
```bash
./gradlew test
```

### 4. Execute the Application
```bash
./gradlew run
```

### 5. Run Custom Information Task
```bash
./gradlew appInfo
```

---

## 🧪 Unit Testing Results

Tests were executed using JUnit 5 Jupiter Platform. Test results:
- `testAddTask()` — PASSED
- `testMarkTaskAsCompleted()` — PASSED
- `testMarkInvalidTaskId()` — PASSED
- `testFilterCompletedAndPendingTasks()` — PASSED
- `testInvalidTaskTitle()` — PASSED
- `testClearAllTasks()` — PASSED

---

## 🔄 CI/CD Pipeline Integration (GitHub Actions)

### What is CI/CD?
**CI/CD** stands for **Continuous Integration and Continuous Delivery/Deployment**:
- **Continuous Integration (CI):** Automatically builds, tests, and validates code changes whenever code is pushed to the repository.
- **Continuous Delivery (CD):** Automatically packages code into executable artifacts ready for deployment.

### Workflow Configuration: `.github/workflows/java-gradle-ci.yml`

#### When it Runs:
The pipeline triggers automatically on:
- Every `push` to `main` or `master` branches.
- Every `pull_request` targeting `main` or `master` branches.

#### What the Pipeline Does:
1. **Checkout Code:** Uses `actions/checkout@v4` to fetch repository files.
2. **Set up JDK:** Configures OpenJDK 17 using `actions/setup-java@v4` with build caching for Gradle dependencies.
3. **Execute Gradle Build:** Runs `./gradlew build` to compile Java sources and check syntax.
4. **Run Automated Tests:** Runs `./gradlew test` to execute all JUnit 5 test cases.
5. **Upload Artifacts:**
   - Uploads JUnit HTML test reports as an artifact (`junit-test-report`).
   - Uploads compiled JAR files as an artifact (`java-app-jar`).

### How Gradle Automates the Process
Gradle acts as the build engine inside the GitHub Actions runner. By defining build logic, dependencies, and test executions in `build.gradle`, the CI workflow executes the exact same build logic locally and in the cloud, guaranteeing consistent and repeatable builds.
