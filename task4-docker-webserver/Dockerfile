# Official lightweight Nginx image on Alpine Linux
FROM nginx:1.25-alpine

# Metadata labels
LABEL maintainer="Mysura Reddy"
LABEL description="CodeAlpha DevOps Internship - Task 4 Web Server"

# Copy custom Nginx configuration
COPY nginx.conf /etc/nginx/nginx.conf

# Copy static website files into Nginx document root
COPY index.html /usr/share/nginx/html/index.html

# Expose port 80 for HTTP traffic
EXPOSE 80

# Healthcheck to monitor container health
HEALTHCHECK --interval=30s --timeout=3s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost/ || exit 1

# Start Nginx in the foreground
CMD ["nginx", "-g", "daemon off;"]
