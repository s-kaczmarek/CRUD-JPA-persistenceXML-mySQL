package controller;

import domain.Employee;
import domain.EmployeeRepository;
import jpa.utils.JPAUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static jpa.utils.JPAUtils.entityManager;

public class ControllerTest {

    @Test
    public void shouldAddNewEmployee(){

        String firstNameTest = "Jon";
        String lastNameTest = "Doe";
        double salary1test = 10.0;
        String salary2test = "10.00";
        String localityTest = "LosAngeles";
        String zipCodeTest = "00-000";
        String streetTest = "LosAngeles str.";
        int streetNumberTest = 10;

        Employee testEmployee = new Employee(
                firstNameTest,
                lastNameTest,
                salary1test,
                salary2test,
                localityTest,
                zipCodeTest,
                streetTest,
                streetNumberTest);

        EmployeeRepository.addNewEmployeeFromCLI(testEmployee);

        String customQueryFindJonDoe = "select e from Employee e where e.firstName = :firstName and e.lastName = :lastName";

        EntityManager entityManager = JPAUtils.openEntityManager();
        TypedQuery<Employee> foundJonDoe = entityManager.createQuery(customQueryFindJonDoe, Employee.class);
        foundJonDoe.setParameter("firstName", firstNameTest);
        foundJonDoe.setParameter("lastName", lastNameTest);

        List<Employee> results = foundJonDoe.getResultList();

        Employee jonDoeObject = results.get(0);

        long idToDelete = jonDoeObject.getId();

        Assertions.assertNotEquals(null, foundJonDoe);

        if (entityManager.isOpen()) {
            entityManager.close();
        }

        EmployeeRepository.deleteEmployee(idToDelete);

    }
}
