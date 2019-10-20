# plata-bank

## API

### Eureka server
  http://localhost:8761/
  
### API gateway server
  http://localhost:8761/

### customer-service
>.
### account-service
> To create a new account<br>
  GET http://localhost:8080/account/create/checking <br>
  GET http://localhost:8080/account/create/saving <br>
  GET http://localhost:8080/account/create/salary <br>

  
  >  To list all account by type<br>
  GET http://localhost:8080/checkingAccounts<br>
  GET http://localhost:8080/savingAccounts<br>
  GET http://localhost:8080/salaryAccounts<br>
  

  > To get one by type and ID<br>
  GET http://localhost:8080/checkingAccounts/{id}<br>
  GET http://localhost:8080/savingsAccounts/{id}<br>
  GET http://localhost:8080/salaryAccounts/{id}
  
  > To get all Accounts<br>
  GET http://localhost:8080/accounts/all
  
<hr>
