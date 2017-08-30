GET: localhost:8081/employees

GET :localhost:8081/api/employees/?deptName="HR"&salary=10000

POST:http://localhost:8081/api/employee
	
Body:

{   
    "employeeName": "Pankaj",
    "deptName": "Technology",
    "salary": 10000
  }

PUT:
http://localhost:8081/api/employee/1

DELETE:
http://localhost:8081/api/employee/1