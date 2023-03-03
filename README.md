# Quote Finance API
Spring boot REST API project using jpa (Springboot REST API which connects MySQL database).

Setup
-----
- Clone and open in Intellij Idea IDE
- Change database connection config in `src/main/resources/application.properties`
- Install maven dependencies using IDE auto import or using the command ``mvn install``
- Run the app using ``mvn spring-boot:run``
- Browse ``http//localhost:8080/quotes``
- Create package for deployment using ``mvn package`` (change properties if required)

Table Structure
---------------
``CREATE TABLE quotes(

    id bigint not null auto_increment,
    symbol varchar(100) not null,
    price DECIMAL(65) ,
    country varchar(4) not null,
    primary key(id)

);``

``CREATE TABLE users(

    id bigint not null auto_increment,
    login varchar(100) not null,
    password varchar(255) not null,

    primary key(id)

);``
    
API Doc & Sample
----------------
- List all quotes 
    ```
    GET /quotes
    POST /quotes
    CREATE /quotes
    DELETE /quotes
    ```
    Body Quote Example:
    ```
    {
        "id":1,
        "symbol": "BTC",
        "price": "220900",
        "country": "EUA"
    }
    ```
-   users
    ```
    GET /users
    POST /users
    CREATE /users
    DELETE /users
    
    {
        "login":"teste@api.com",
        "password": "123456",
    }
    ```
    
- Note 
to use the api, you must authenticate with the user's login and password, an access token will be generated when logging in
- ![image](https://user-images.githubusercontent.com/71887970/222826870-53e529d7-51f8-4a3d-9e21-51e5fdb827cc.png)

-----
