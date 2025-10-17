**Repository:** [MikeBrownSNHU / CS-305 – Module 7](https://github.com/MikeBrownSNHU/CS-305/tree/474aee1b36d628603e60ac8eee003dbc278e1127/Module-7)  
**Author:** Mike Brown  
**Course:** SNHU – CS 305 Secure Software Development

# Artemis Financial – Secure Software Project

## Client Overview
**Client:** Artemis Financial  
**Partner:** Global Rain Software  

Artemis Financial is a consulting firm that creates personalized financial plans for clients covering savings, investments, retirement, and insurance. They requested help improving the security of their existing web application.  
The main goal was to modernize the platform by ensuring all client data and file transfers were encrypted and verified. This included adding a cryptographic checksum and converting all communication from HTTP to HTTPS.

---

## What Went Well
I successfully identified weaknesses in the original code and refactored the project to include secure communication and encryption.  
Key improvements:
- Implemented SHA-256 checksum verification for file integrity  
- Added a self-signed TLS certificate for encrypted HTTPS connections  
- Configured secure server settings in Spring Boot  

This project reinforced how important it is to write code with security in mind. Secure coding protects customer information, maintains trust, and helps prevent financial and reputational loss for companies like Artemis Financial.

---

## Challenges and Takeaways
The most challenging part of this project was generating and configuring the SSL certificate correctly so the application would run securely over HTTPS. Once the certificate was working, it was rewarding to see the browser show a valid lock icon and connect securely.  

I also found the OWASP Dependency-Check tool extremely helpful for identifying potential issues in third-party libraries. It showed how vulnerabilities can exist even when the main application code is clean.

---

## Layers of Security Added
Steps I took to strengthen security:
- Enabled full HTTPS (TLS 1.2/1.3) communication  
- Added a SHA-256 checksum endpoint for data verification  
- Improved input validation and exception handling  
- Integrated OWASP Dependency-Check for static vulnerability scanning  

In future projects, I plan to use a mix of automated tools (OWASP ZAP, Dependency-Check) and manual reviews to assess risks and choose the best mitigation strategies.

---

## Functional and Security Testing
After refactoring, I:
- Rebuilt and ran the application to confirm normal operation  
- Tested the checksum endpoint with various data inputs  
- Verified HTTPS access via `https://localhost:8443/hash`  
- Ran Dependency-Check to ensure no new vulnerabilities were introduced  

All tests completed successfully, confirming that the application remained functional and secure.

---

## Tools and Resources Used
- Java Keytool – for generating and exporting SSL certificates  
- Spring Boot – for configuring HTTPS and REST endpoints  
- OWASP Dependency-Check – for static analysis and CVE detection  
- Secure coding practices – input validation, least privilege, safe logging  

These tools and habits will continue to be valuable in future secure development projects.

---

## Reflection and Portfolio Value
This project gave me practical, hands-on experience applying encryption, TLS, and vulnerability scanning to a live Java application.  
It demonstrates my ability to:
- Configure HTTPS and certificates  
- Implement cryptographic hashing (SHA-256)  
- Identify and remediate security vulnerabilities  

I plan to use this project in my portfolio to show future employers my understanding of secure software design, encryption best practices, and professional testing workflows.

---

