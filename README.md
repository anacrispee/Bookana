# Bookana

This is an Android app in active development, designed to help you explore and organize your favorite books.

---

## ⚠️ Project Status: In Progress 🔨

This project is under active development. New features, improvements, and bug fixes are being implemented continuously. Feel free to follow our progress!

---

## Technologies & Architecture

Bookana is built on a solid technological foundation to ensure clean, scalable, and maintainable code.

* **Kotlin**
* **MVVM (Model-View-ViewModel)**
* **Koin**
* **Retrofit**: Responsible for all our network requests, to consume APIs for the **book exploration** feature.
* **Room**: A data persistence library that facilitates local storage. Essential for the **saving books to the bookshelf** feature.
* **Multi-module Architecture**: The project is divided into modules. This structure ensures a clear separation of concerns, facilitating collaboration and scalability.
* **Custom Gradle Plugin**: custom Gradle plugin to centralize build configurations across all modules. This prevents code duplication and standardizes the development environment.

---

## Current Features

* **Explore Books**: Search for books through an external API and view their details.
* **Save to Bookshelf**: Save your favorite books to a virtual bookshelf, which is stored locally on your device.
