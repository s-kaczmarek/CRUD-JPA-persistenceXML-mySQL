package domain;

import jpa.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static jpa.utils.JPAUtils.entityManager;

public class EmployeeRepository {

    public static void listAllEmployees() {

        EntityManager entityManager = JPAUtils.openEntityManager();
        List<Employee> listEmployee = entityManager.createQuery("SELECT e FROM Employee e").getResultList();

        if (listEmployee == null) {
            System.out.println("No employee found. ");
        } else {
            for (Employee empl : listEmployee) {
                System.out.println(empl.toString());
            }
        }

        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public static void listEmployeeById(Long id) {
        try {

            EntityManager entityManager = JPAUtils.openEntityManager();
            Employee employeeById = entityManager.find(Employee.class, id);
            System.out.println(employeeById.toString());

        } catch (NullPointerException e) {
            System.out.println("No employee with this id!");
        }

        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public static void addNewEmployeeFromCLI(Employee newEmployee) {
        EntityManager entityManager = JPAUtils.openEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newEmployee);
        entityManager.getTransaction().commit();

        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public static void editExistingEmployeeFromCLI(Employee employeeToMerge) {

        EntityManager entityManager = JPAUtils.openEntityManager();

        entityManager.clear();
        entityManager.getTransaction().begin();
        entityManager.merge(employeeToMerge);
        entityManager.getTransaction().commit();

        System.out.println("Employee updated successfully!!!");

        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public static void deleteEmployee(long idToDelete) {

        EntityManager entityManager = JPAUtils.openEntityManager();
        Employee EmployeeToDelete = entityManager.find(Employee.class, idToDelete);

        entityManager.getTransaction().begin();
        entityManager.remove(EmployeeToDelete);
        entityManager.getTransaction().commit();

        System.out.println("Employee removed successfully!!!");

        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
