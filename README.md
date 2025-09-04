# api-sb-test

## Project Overview

This project is a Java-based API testing suite using JUnit 5 and Rest Assured. 
It validates API responses and JSON schemas for company-related endpoints.

## Prerequisites

- **Java 17** or higher
- **Git** (to clone the repository)
- **Internet connection** (for Gradle to download dependencies)

> **Note:** You do NOT need to install Gradle manually. The project includes the Gradle Wrapper (`gradlew`/`gradlew.bat`).

## Setup Instructions

1. **Install Java JDK**
   - Download and install from [Oracle](https://www.oracle.com/java/technologies/downloads/).
   - Set `JAVA_HOME` and ensure `java` is in your `PATH`.

2. **Clone the repository:**
   ```sh
   git clone <your-repo-url>
   cd api-sb-test
   ```

3. **Build the Project**
   ```sh
   ./gradlew build
   ```

4. **Run the Tests**
   ```sh
   ./gradlew test
   ```

## Project Structure

- `src/main/java/api/model/` — Data models
- `src/test/java/api/test/` — Test classes
- `src/test/resources/json_schema/` — JSON schema files for validation

## Useful Gradle Commands

- `./gradlew clean` — Clean build artifacts
- `./gradlew test` — Run all tests

## Troubleshooting
- If you encounter issues with dependencies, try running `./gradlew clean build`.
- Ensure your JAVA_HOME environment variable points to a Java 17+ installation.

## Sample Test Run Video
You can find a sample video of a running test in the `record` folder:

- `record/test_result.mov`
