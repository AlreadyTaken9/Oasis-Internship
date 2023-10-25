# Online Exam System

This is a simple Java program for an online exam system. The program allows users to log in, take an exam, and update their profile and password. Below, you'll find information on how to run and use this program.

## Table of Contents
- [Introduction](#introduction)
- [How to Run](#how-to-run)
- [Features](#features)
- [Code Overview](#code-overview)
- [User Guide](#user-guide)

## Introduction

The Online Exam System is a text-based Java application that simulates an online exam. It provides functionality for user authentication, taking an exam, and updating user profiles and passwords.

## How to Run

1. Ensure you have Java installed on your system.

2. Save the code to a file with a `.java` extension, such as `OnlineExamSystem.java`.

3. Open a terminal or command prompt and navigate to the directory where the file is saved.

4. Compile the code using the following command:
   ```
   javac OnlineExamSystem.java
   ```

5. Run the program using:
   ```
   java OnlineExamSystem
   ```

## Features

- **User Authentication**: Users can log in with their username and password. Dummy user data is provided in the code.

- **Exam Taking**: Once logged in, users can take an exam. The exam includes multiple-choice questions with a time limit.

- **Timer**: A timer keeps track of the time remaining for the exam. The default exam duration is 60 seconds.

- **Scoring**: The program calculates and displays the user's score at the end of the exam.

- **Profile Update**: Users can update their password.

## Code Overview

The code consists of several classes:

- `User`: Represents a user with a username and password.

- `Question`: Represents a multiple-choice question.

- `OnlineExamSystem`: The main class that manages user interaction, exam taking, and user authentication.

The program uses a simple menu-based interface for user interaction. It provides options for logging in, updating the user's profile, and taking an exam. A timer is used to limit the duration of the exam.

## User Guide

1. **Login**: When you run the program, you will be prompted to log in with a username and password. You can use the dummy user data provided in the code (user1/password1 and user2/password2).

2. **Main Menu**:
   - If you log in successfully, you can choose to update your profile or log out.
   - If you choose to update your profile, you can change your password.

3. **Exam**:
   - When logged in, you can start the exam.
   - The exam consists of multiple-choice questions with a time limit.
   - Select your answer by entering 'A', 'B', 'C', or 'D' for each question.
   - The program will display whether your answer is correct or incorrect and keep track of your score.

4. **Timer**:
   - If the timer reaches zero, the exam is automatically submitted.

5. **Exam Result**: After completing the exam, the program will display your score.

6. **Logout**: You can log out to return to the main menu.

7. **Exit**: You can exit the program from the main menu.

That's it! You can use this program to simulate an online exam system.
