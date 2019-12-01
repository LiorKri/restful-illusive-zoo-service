# Illusive Zoo Management REST API Service

This is a RESTful web service application implemented using Spring MVC and Java. The service provides an in-memory zoo management service with the following capabilities:

 - Create - Create an animal and add it to the zoo.
 - Read - Get a single animal.
 - Update - Update animal details.
 - Delete - Delete animal from the zoo.
 - Feed - Feed an animal.
 - Clean - Clean animal cave.
 - Sleep - Get animal awakens state.

Time estimation: 4 hours
## Starting Illusive Zoo Service
First of all, make sure you have installed [Maven](https://maven.apache.org/install.html).
Then open the Command Line and run

    run.bat
    
When the web service is started, it can be reached at

    http://localhost:8081/zoo

## Test and Logs
Logs can be found in

    /logs/logs.log

Open the Command Line and run the following in order to run unit tests

    mvn test


## Endpoints
The following REST endpoints are available:

| HTTP Verb        | URL           | Description  | Status Codes |
| ------------- |-------------|:-----| ----|
| `GET` | `http://localhost:8081/zoo` | Obtains a list of all existing animals | <ul><li>`200 OK`</li></ul> |
| `GET` | `http://localhost:8081/zoo/{id}` | Obtains the animal according to the given animal ID | <ul><li>`200 OK` if animal exists</li><li>`404 Not Found` if animal does not exist</li></ul> |
| `POST` | `http://localhost:8081/zoo` | Creates a new animal based on the payload contained in the request body | <ul><li>`201 Created` if animal successfully created</li></ul> |
| `PUT` | `http://localhost:8081/zoo/{id}` | Updated an existing animal with the data contained in the request body | <ul><li>`200 OK` if animal successfully updated</li><li>`404 Not Found` if animal does not exist</li></ul> |
| `DELETE` | `http://localhost:8081/zoo/{id}` | Deletes an existing animal according to the supplied animal ID | <ul><li>`204 No Content` if animal successfully deleted</li><li>`404 Not Found` if animal does not exist</li></ul> |
| `PUT` | `http://localhost:8081/zoo/{id}/Feed` | Updated an existing animal last meal time to be now | <ul><li>`200 OK` if animal successfully updated</li><li>`404 Not Found` if animal does not exist</li></ul> |
| `PUT` | `http://localhost:8081/zoo/{id}/Clean` | Updated an existing animal last cleaning time to be now | <ul><li>`200 OK` if animal successfully updated</li><li>`404 Not Found` if animal does not exist</li></ul> |
| `PUT` | `http://localhost:8081/zoo/{id}?isSleep={isSleep}` | Updated an existing animal awakens state according to the given boolean param | <ul><li>`200 OK` if animal successfully updated</li><li>`404 Not Found` if animal does not exist</li></ul> |

## Future Improvements

- Adding connection to DB.
- Adding frontend using Angular.
- Adding more options to the management system like Employee management, Visitors management etc.
- Adding authentication and permissions for all actions within the service.
