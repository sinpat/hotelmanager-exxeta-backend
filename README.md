# hotelmanager-exxeta-backend

Backend-Repository für den Hotelmanager der Exxeta Challenge

## Run the application

`./gradlew bootRun`

### Providing a database connection

The application requires a running PostgreSQL instance.
You can start one using [Docker](https://hub.docker.com/_/postgres/):

```
docker pull postgres
docker run --name <NAME> -p 5432:5432 -e POSTGRES_DB=hotelmanager -e POSTGRES_PASSWORD=<PASSWORD> postgres
```
The `<PASSWORD>` needs to match the one given in [the application properties](./src/main/resources/application.properties).
