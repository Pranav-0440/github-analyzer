# 🚀 GitHub Analyzer API

A cloud-deployed Spring Boot backend application that analyzes a GitHub user's public profile and repositories using the GitHub REST API.

🌍 **Live API:**  
https://github-analyzer-6pxt.onrender.com/api/github/analytics/{username}

---

## 📌 Project Overview

GitHub Analyzer is a REST API that:

- Fetches public GitHub user data
- Retrieves all repositories
- Calculates:
  - Total repositories
  - Total stars
  - Total forks
  - Most used programming language
- Returns structured analytics JSON

This project demonstrates:

- Spring Boot backend development
- External API integration
- Token-based authentication
- Business logic aggregation
- Docker containerization
- Cloud deployment (Render)

---

## 🛠 Tech Stack

- Java 21
- Spring Boot 4
- Maven
- GitHub REST API
- Docker
- Render (Cloud Deployment)

---

## 🔗 API Endpoints

### 1️⃣ Get Basic User Info

GET /api/github/{username}

Example:
```
https://github-analyzer-6pxt.onrender.com/api/github/Pranav-0440
```

Response:

```json
{
  "login": "Pranav-0440",
  "public_repos": 27,
  "followers": 34,
  "following": 24
}
```

### 2️⃣ Get GitHub Analytics

GET /api/github/analytics/{username}

Example:
```
https://github-analyzer-6pxt.onrender.com/api/github/analytics/Pranav-0440
```

Response:

```json
{
  "username": "Pranav-0440",
  "totalRepos": 27,
  "totalStars": 17,
  "totalForks": 0,
  "mostUsedLanguage": "Python"
}
```

## ⚙️ How It Works

1. Controller receives request
2. Service layer calls GitHub REST API
3. Repository data is fetched
4. Business logic calculates:
    - Stars sum
    - Forks sum
    - Language frequency

5. Structured JSON response returned

### Architecture Flow:

```text
Client → Controller → Service → GitHub API → Aggregation → JSON Response
```

## 🔐 Environment Variables
The app requires a GitHub Personal Access Token.

Set as environment variable:

```text
GITHUB_TOKEN=your_token_here
```

In `application.properties`:

```properties
github.token=${GITHUB_TOKEN}
server.port=${PORT:8080}
```

## 🐳 Docker Deployment
Dockerfile is included.

#### Build & Run locally:

```bash
docker build -t github-analyzer .
docker run -p 8080:8080 github-analyzer
```

## ☁️ Cloud Deployment
Deployed using:
- Docker
- Render Free Instance

Live URL:
```url
https://github-analyzer-6pxt.onrender.com
```

## 🎯 Future Improvements
- Developer score algorithm
- Swagger API documentation
- Caching layer
- Frontend dashboard
- Database persistence
- CI/CD pipeline

## 👨‍💻 Author
Pranav Ghorpade
Electronics & Telecommunication Engineering
Backend Developer | Java | Spring Boot

⭐ If You Like This Project
Give it a star on GitHub ⭐