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

## Customer

### Create

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