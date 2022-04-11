# HerbieSampleCode

## CONTENTS OF THIS FILE
------------------------
* [Introduction]
* [Goal]
* [Technologies]
* [Installation]
* [Setup]
* [Design]
* [Resources]
* [Visuals]
* [Contributing]

## Introduction
```bash
Herbie is a Client Relationship Application to help improve & better understand the connections between Drive Capital and its business-partners.
```

## Goal
This app is inspired by Drive Capital internal client relationship management application - Herbie. This project is a simple application built using use IntelliJ Idea as my IDE, Spring Boot via Gradle, thymeleaf templating engine, and a H2 in-memory database of 100 fictious client-partner employees. 

Based on the project description it sounded like the application was a more sophisticated Client Relation Management program. I thought and outlined what the minimum viable product for a crm would be and crossed reference that with the application outline. From there...  

I created an four pages application
    - Home screen
    - List/Database screen
        - showing a data table of all known company contacts, the partner relationship, and the contact method most suitable to them. 
        - I also wanted to allow the user to browse the table, rearrange it in alphabetical or chronological order, and find the client based on any of the categories. 
        - I paginated the results so the table would short and return only relevant results. 
        - !!! IMPORTANT !!! - Search feature is case sensitive - !!! IMPORTANT !!!   
    - Create screen
    - Edit/Delete screen

## Technologies
```bash
Project is created with:
    * Spring Boot 2.6.4
        - Spring Boot DevTools
        - Spring Web
        - Spring Data JPA
        - H2 Database
        - Thymeleaf
    * Java
    * Gradle
``` 

## Installation
```bash
Download the zip file, extract, and open in Intellij or VS Code via gitbash or terminal. 
```

## Setup
```bash
To run this project, download the zip file and access using intellij or VS Code
run the ScApplication
open http://localhost:8080/ in your browser
```

## Resources 
```bash
https://start.spring.io/
https://www.mockaroo.com/4ff5f150
The Art of CRM - By Max Fatouretchi - ISBN 9781789538922
Spring Boot Essentials - By Matthew Speake - ISBN 9781801070737
Getting Started with Spring Boot 2 - By Dan Vega - ISBN 9781839217562
```

## Contributing
Pull requests are welcome. If you have any edits you wish to make please open an issue first to track keeping purposes. Feel free to create any tests.