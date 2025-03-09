# Art Studio Management System

## Overview

This project is a *Java-based art studio workshop management system* that allows users to handle participants, trainers, and schedules using OOP principles. It features a Java Swing GUI and connects to a PostgreSQL database for data management.

## Features

- *GUI Built with Java Swing* for intuitive user interaction.
- *PostgreSQL database connection* for storing participants, trainers, and feedback.
- *Encapsulation, inheritance, and polymorphism* for structured and maintainable code.
- *Workshop scheduling and review system* for managing feedback.
- *Database connection class* for data retrieval.

## Technologies Used

- *Java*
- *Java Swing (GUI)*
- *PostgreSQL (Database)*
- *JDBC (Java Database Connectivity)* for database interaction

## Project Structure
- `Main.java`: Entry point of the application.
- `GUI.java`:  Handles user interactions and UI components.
- `DatabaseConnection.java`: Manages PostgreSQL connectivity securely.
- `Person.java`, `Participant.java`, `Trainer.java`:  OOP-based entity representations.
- `Workshop.java`, `Schedule.java`, `Studio.java`: Core workshop and scheduling logic.
- `Feedback.java`, `Reviewable.java`:  Handles participant feedback and ratings.

## Setup & Installation

1. Install *Java (JDK 8 or higher)*.
2. Set up a *PostgreSQL database* and update DatabaseConnection.java with your credentials.
3. Compile and run the project.
