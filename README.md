# Fitness Warehouse

Fitness Warehouse is a web-based inventory management system built with Spring Boot for CPAN-228 Web Application Development. The application allows users to view products, add new products through a form, validate user input, and browse saved records using filtering and sorting features.

## Features

- Home page with project overview
- About page describing the application
- Products list page
- Add Product form
- Server-side validation with clear error messages
- H2 database persistence using Spring Data JPA
- Sample product data loaded on startup using `data.sql`
- Filtering by brand and category
- Sorting by name and price
- Bootstrap styling with a custom red-and-white futuristic fitness theme

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Thymeleaf
- Spring Data JPA
- H2 Database
- Spring Validation
- Spring Security
- Bootstrap 5
- Custom CSS

## How to Run

1. Clone the repository
2. Open the project using a Java IDE
3. Run `FitnessWarehouseApplication.java`
4. Open `http://localhost:8080` in your browser

## Pages

- `/` - Home page
- `/about` - About page
- `/products` - Product list with filtering and sorting
- `/products/new` - Add Product form

## Team Members and Roles

- **Julila Mpesha** — Backend architecture, data model, validation, persistence, service logic
- **Ben Aharon** — Frontend layout, Thymeleaf templates, forms, styling
- **Brayden Bourgeois** — Controllers, routing, application flow, security integration

## Current Deliverable

This version demonstrates the Deliverable 1 requirements for:
- navigation and pages
- a working form
- validation
- database persistence
- list view with search and sort
- sample data on startup
- Bootstrap-based styling
