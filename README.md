# account-manager - Spring Boot Application

This is a Standalone Spring Boot Project for Accounts' management by authorized users. 

## 1. Building the project
The project is a maven project, and needs to be built by the following statement:
```
  mvn clean install
```

## 2. Database

H2 database

After starting the Spring Boot Application, one can access the db console by the following url:
```
  http://localhost:8080/h2-console
  Username: admin
  Password: admin
```

## 2.1 Insert user into DB
The applications uses a volatile database, which means that all the stored data is deleted when the application is stoped. For this, there needs 
to be inserted at least one user by using the following expression: 
```
  INSERT INTO USERS VALUES (1, TO_DATE('01-Apr-2000'), 'Tim', 'Johnson');
```

## 3. Managing accounts
In order to perform any operations on the application, one needs to authenticate itself.To do this, call the following method on localhost:
```
  POST http://localhost:8080/authenticate
```
The response contains a jwt token, which can be used to perform further calls.

To get all accounts of all users, one needs first to set the Authorization Header attribute in the following way:
```
  Authorization     Bearer jwtToken
```
Then, perform the following call:
```
  GET http://localhost:8080/accounts
```
For the first time, most probably you will receive an empty list of accounts. This happens because there is no account in the database. 
In order to add accounts, one needs to perform the following call (after setting the Authorization header attribute as described before):
```
  POST http://localhost:8080/accounts 
  Body: {
            "id": null,
            "balance": 9999.99,
            "type": "SAVING",
            "openingDate": "2020-09-16T14:56:39.492",
            "userId": 1
        }
```

## 4. Prerequirements and validations

Check API documentation here: 
```
  http://localhost:8080/v2/api-docs
```
For inserting an account into the database, first there needs to be a valid user stored. In case there is no user, or the mentioned user in the 
request body, a validation exception is thrown. The id of the given account is null, because the it will be set at insert.
There are also implemented the following validations: 
  - a user can have only one SAVING account, but any number of CHECKING accounts
  - an account cannot be open during weekends or outside of working hours (9-17)
