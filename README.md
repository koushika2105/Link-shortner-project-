# Link-shortner-project-
🔗 Link Shortener & QR Code Generator

A scalable URL shortening service built with Spring Boot and PostgreSQL that allows users to create short, shareable links and generate QR codes. The application uses JWT-based authentication to ensure secure access and seamless link management.

🚀 Features
🔐 Secure authentication and authorization using JWT
✂️ Convert long URLs into short, easy-to-share links
🔁 Automatic redirection to the original URL
📱 QR code generation for each shortened link
🧩 RESTful APIs for integration with other services
🛠️ Tech Stack
Backend: Spring Boot (Java)
Database: PostgreSQL
Security: Spring Security with JWT
QR Code Generation: (e.g., ZXing or any library you used)
📌 How It Works
Users register and log in to receive a JWT token
Authenticated users can create shortened URLs
Each short link maps to the original URL in the database
When accessed, the short link redirects to the original URL
QR codes are generated for quick sharing and scanning
🔒 Security
JWT-based authentication and authorization
Protected endpoints using Spring Security
Stateless session management
📦 Use Cases
Sharing clean and minimal links
Generating QR codes for marketing, events, and products
Efficient URL management for applications
