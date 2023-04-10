## About Me
My name is ```Almehraz Khashem```, I am a beginner Java developer who is currently in the training stage at the IT Academy. I am determined to become a leading java developer in order to push my limits and develop in an intellectual and logical level

<!-- ABOUT THE PROJECT -->
## About The Project

This project was developed by me as a solution to the technical task for QA at the IT academy where I study.
"project-city" is a service that accepts and responds to HTTP requests. Basically, all models and methods are based on objects such as a city, a street, or a store.
This project is basically a simple filtering of stores based on your city and street.


<!-- GETTING STARTED -->
## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.


### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. create database "cs" with pgAdmin
2. in application.properties add the following settings, while remembering to remove the previous ones
   ```sh
   spring.datasource.url=jdbc:postgresql://localhost:5432/cs
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.generate-ddl=true
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=create
   ```
3. run main method in CityShopApplication
4. after the first run, change the ```sh spring.jpa.hibernate.ddl-auto=create field``` to ```sh spring.jpa.hibernate.ddl-auto=update```
