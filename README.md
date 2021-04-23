# Install Java

```shell
sudo apt install openjdk-11-jre-headless
```

```shell
sudo apt-get install maven
```

# Install postgres

```shell
sudo apt-get -y install postgresql
```

You might need to create a password for the postgres user in order to connect to the database.

```shell
sudo -u postgres psql
```

```shell
ALTER USER postgres PASSWORD 'password';
```

Create database:

```shell
create database walmart;
```

Update `src/main/resources/application.properties` with database credentials if needed.

# Run application

```shell
mvn spring-boot:run
```

If you see an error like: `database "walmart" does not exist"` or `password authentication failed for user postgres` please make sure the database is set up correctly

# Curl
The app is deployed to heroku. If testing locally use `localhost:8080`

Due to being deployed on the free teir in Heroku, if the endpoint is inactive the app will go into a sleep state. It might take a few seconds to a minute to wake up and process requests. If the request is taking a long time please try again a minute or so. It the app doesn't wake up feel free to reachout to me and I can restart it. 

## Customer

### Create
Returns a new customer.
```shell
curl --location --request POST 'https://walmart-demo-app.herokuapp.com/customer' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Mike Test"
}' 
```

```json
{
  "id": 6,
  "name": "Mike Test"
}
```

### Get
Returns a customer.
Throws 404 if customer does not exist.
```shell
curl --location --request GET 'https://walmart-demo-app.herokuapp.com/customer?customerId=6'
```

```json
{
  "id": 6,
  "name": "Mike Test"
}
```

### Update
Returns an updated customer.
Throws 404 if customer does not exist.
```shell
curl --location --request PATCH 'https://walmart-demo-app.herokuapp.com/customer?customerId=6' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Mike Updated"
}'
```

```json
{
  "id": 6,
  "name": "Mike Updated"
}
```

## Order

### Create
Returns a new order.
Throws 412 if customerId is invalid.
```shell
curl --location --request POST 'https://walmart-demo-app.herokuapp.com/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "customerId": "6"
}'
```

```json
{
  "id": 9,
  "customerId": 6
}
```

### Get
Returns an order.
Throws 404 if order does not exist.
```shell
curl --location --request GET 'https://walmart-demo-app.herokuapp.com/order?orderId=9'
```

```json
{
  "id": 9,
  "customerId": 6
}
```

### Add Item
Returns an updated order line.
Throws 412 if qty, orderId or itemId is invalid.
```shell
curl --location --request PUT 'https://walmart-demo-app.herokuapp.com/order/addItem?orderId=9&itemId=3' \
--header 'Content-Type: application/json' \
--data-raw '11'
```

```json
{
  "orderLinePK": {
    "orderId": 9,
    "itemId": 3
  },
  "qty": 11
}
```

### Remove Item
Returns an updated order line or 204 if the order line is deleted due to the qty being < 0. 
Throws 412 if order line does not exist or if the qty, orderId or itemId is invalid.

```shell
curl --location --request PUT 'https://walmart-demo-app.herokuapp.com/order/removeItem?orderId=9&itemId=3' \
--header 'Content-Type: application/json' \
--data-raw '2'
```

```json
{
  "orderLinePK": {
    "orderId": 9,
    "itemId": 3
  },
  "qty": 5
}
```

## Recommendation

### Get
Returns a list of items that have the most qty

```shell
curl --location --request GET 'https://walmart-demo-app.herokuapp.com/recommendation?numberOfTopItems=3'
```

```json
[
  {
    "id": 16,
    "name": "Great Value 1% Chocolate Milk, Half Gallon"
  },
  {
    "id": 3,
    "name": "Del Monte Summer Crisp Whole Kernel Golden Sweet Corn, 11 Oz"
  },
  {
    "id": 7,
    "name": "Fresh Strawberries, 2 lb"
  }
]
```

# Pros and cons to your recommendation approach

## Pro
* Simple spring boot app with postgresql as the database.
* Recommendation computation is done via sql

## Cons
* A lot of files are needed in order to create a simple api endpoint.
