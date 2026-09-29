# Task 4: Web Server using Docker

**CodeAlpha DevOps Internship**  
**Author:** Mysura Reddy  
**Project:** Containerized Nginx Web Server  
**Tech Stack:** Docker, Nginx (Alpine Linux), Docker Compose, HTML5/CSS3  

---

## 📌 Project Overview

This project containerizes a custom high-performance **Nginx Web Server** using **Docker** and **Docker Compose**. It demonstrates containerization fundamentals, image building, container lifecycle management, custom Nginx configuration, and container health checks.

---

## 📚 Core Concepts Explained

### 1. What is Docker?
**Docker** is an open-source platform that enables developers to package applications and their dependencies into lightweight, portable units called containers. Docker eliminates the "it works on my machine" problem by standardizing software execution environments across development, testing, and production servers.

### 2. What is a Container?
A **container** is a isolated, lightweight runtime environment that shares the host operating system's kernel while isolating application code, runtime libraries, and system dependencies. Unlike traditional Virtual Machines (VMs), containers do not require a guest OS per instance, making them fast to boot (seconds) and memory efficient.

### 3. What is Nginx?
**Nginx** (pronounced "engine-x") is an industry-standard, high-performance, open-source HTTP web server, reverse proxy, load balancer, and HTTP cache. It utilizes an asynchronous, event-driven architecture capable of handling tens of thousands of concurrent connections efficiently.

### 4. Why is Nginx being used?
- **High Performance:** Lightweight footprint with low memory consumption.
- **Static Content Delivery:** Optimized for serving HTML, CSS, JavaScript, and images at high speed.
- **Production Standard:** Used widely in DevOps, microservices architectures, and enterprise deployments.

---

## 📄 Docker Configuration Files Explained

### 5. `Dockerfile` Explanation
Line-by-line breakdown of `task4-docker-webserver/Dockerfile`:

```dockerfile
# Use official lightweight Nginx image on Alpine Linux
FROM nginx:1.25-alpine

# Set metadata maintainer label
LABEL maintainer="Mysura Reddy"

# Copy custom Nginx configuration into the container
COPY nginx.conf /etc/nginx/nginx.conf

# Copy custom index.html into Nginx web root directory
COPY index.html /usr/share/nginx/html/index.html

# Declare that the container listens on port 80
EXPOSE 80

# Configure periodic health check to verify Nginx responsiveness
HEALTHCHECK --interval=30s --timeout=3s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost/ || exit 1

# Start Nginx in foreground mode to keep container active
CMD ["nginx", "-g", "daemon off;"]
```

### 6. `docker-compose.yml` Explanation
Line-by-line breakdown of `task4-docker-webserver/docker-compose.yml`:

```yaml
version: '3.8'

services:
  webserver:
    build:
      context: .
      dockerfile: Dockerfile
    container_name: codealpha-nginx   # Explicit container name
    ports:
      - "8080:80"                     # Maps Host Port 8080 -> Container Port 80
    restart: always                   # Automatically restarts container on failure/reboot
    healthcheck:
      test: ["CMD", "wget", "--quiet", "--tries=1", "--spider", "http://localhost/"]
      interval: 30s
      timeout: 3s
      retries: 3
```

---

## 🛠 Command Reference & Container Lifecycle Guide

### 7. Important Docker Commands
- `docker build`: Compiles a Dockerfile into an executable image.
- `docker run`: Creates and starts a container from an image.
- `docker ps`: Lists running containers.
- `docker logs`: Displays standard output/error logs from a container.
- `docker stop`: Gracefully stops a running container.
- `docker start`: Restarts a stopped container.
- `docker restart`: Restarts a running or stopped container.
- `docker rm`: Removes a stopped container.

---

### 8. How to Build the Docker Image
Navigate to `task4-docker-webserver/` and run:
```bash
docker build -t codealpha-nginx .
```

---

### 9. How to Run the Container
Run the container in detached mode (`-d`) mapping host port `8080` to container port `80`:
```bash
docker run -d --name codealpha-nginx -p 8080:80 codealpha-nginx
```

---

### 10. How to Check Container Status & Health
```bash
# List running containers
docker ps

# Inspect container detailed metadata
docker inspect codealpha-nginx
```

---

### 11. How to View Container Logs
```bash
# View all container logs
docker logs codealpha-nginx

# Follow live container logs
docker logs -f codealpha-nginx
```

---

### 12. How to Stop, Start, and Restart Container
```bash
# Stop container
docker stop codealpha-nginx

# Start container
docker start codealpha-nginx

# Restart container
docker restart codealpha-nginx
```

---

### 13. How to Remove the Container
```bash
# Stop container first
docker stop codealpha-nginx

# Remove container
docker rm codealpha-nginx

# Remove Docker image
docker rmi codealpha-nginx
```

---

### 14. Running with Docker Compose (Recommended)
```bash
# Start container with Docker Compose
docker compose up -d

# Check Compose status
docker compose ps

# View Compose logs
docker compose logs

# Stop and remove Compose services
docker compose down
```

---

### 15. How to Access the Website
Once running, open your web browser or use curl:
- **Browser:** Navigate to `http://localhost:8080`
- **cURL:**
  ```bash
  curl http://localhost:8080
  ```

The website will display:
- **CodeAlpha DevOps Internship**
- **Task 4 - Web Server using Docker**
- **My name: Mysura Reddy**
- **Containerized Nginx Web Server**

---

## ⚠️ Troubleshooting Common Issues

1. **Port 8080 already in use:**
   - Error: `Bind for 0.0.0.0:8080 failed: port is already allocated`
   - Solution: Change port mapping in command or `docker-compose.yml` to `8081:80` or kill the process using port 8080.
2. **Docker daemon not running:**
   - Error: `Cannot connect to the Docker daemon at unix:///var/run/docker.sock`
   - Solution: Start Docker Desktop on Windows/Mac or run `sudo systemctl start docker` on Linux.
