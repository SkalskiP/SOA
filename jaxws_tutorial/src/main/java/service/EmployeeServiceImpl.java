package service;

import domain.Employee;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class EmployeeServiceImpl implements EmployeeService {

    @WebMethod
    public Employee getEmployeeById(String id) {
        return new Employee("1", "Dick Chesterwood");
    }

    @WebMethod
    public String helloWorld() {
        return "Hello World!";
    }
}
