# DziabajApp_2.0

This is my first project created in 2019 for my own development, so please bear with it :)

It's a simple web platform that allows adding products, creating meals, and counting macros in added meals through simple views shown below.
There is also a REST service allowing CRUD operations on the database. 

#### What would I do if I would decide to continue developing the project ?
First of all, there is very weak handling of exceptions and pop-up's lack of checking inserted values, and unit tests
I would also create posibility to delete products & meals, and then I would take care of User Service.
#### In case of creating service which help with creating diet plans I've created simple [Csv To Xlsx](https://github.com/PatrykSzymonMlynczak/CsvToXlsx) paser which was supposed to help complete the database with products, and then I found far better way to create such application -> [NutritionixApi](https://github.com/PatrykSzymonMlynczak/NutritionixApi) 



### Technologies used in project: 
* Java 11
* Spring: 
  * Boot
  * Web
  * Data JPA
  * Mvc
* Maven 
* MySQL
* Thymeleaf
* REST

### Adding Product:

![Cebula](https://user-images.githubusercontent.com/44747531/121522719-af4a8880-c9f5-11eb-8d5d-0e6e2a9af5ab.PNG)

### Creating meal:

![commit posilek](https://user-images.githubusercontent.com/44747531/121522825-cb4e2a00-c9f5-11eb-9aa0-bb990ffe45e0.PNG)

### Calculating macro ingrednients of Meal:

![pokaz kalorie](https://user-images.githubusercontent.com/44747531/121522913-e751cb80-c9f5-11eb-999b-84f6ff52dde8.PNG)







