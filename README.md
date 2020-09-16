# manager-login

## Register

```
curl --location --request POST 'localhost:8095/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName":"rajanikant",
    "role":"Admin",
    "userPassword":"admin"
}'
```

## Login

```
curl --location --request POST 'localhost:8095/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName":"rajanikant",
    "userPassword":"admin"
}'
```


## Get user

```
curl --location --request GET 'localhost:8095/api/user' \
--header 'Content-Type: application/json' \
--header 'Authorization: Token eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWphbmlrYW50IiwidXNlcklkIjoiMTkiLCJyb2xlIjoiQWRtaW4ifQ.pUFfT__JZy2TUk2xkWrFhNIXurfRhLkRO27CSrXbm07yF12gWcQH2B7Zo4AyapAmqHO__Z_pgENJDzrem77QUA'
```

Use authentication token with header; 'Authorization: Token <Token>'
