import controller.Controller;
import domain.Employee;
import domain.EmployeeRepository;
import jpa.utils.JPAUtils;

import java.util.Scanner;

import static jpa.utils.JPAUtils.entityManager;
import static jpa.utils.JPAUtils.entityManagerFactory;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        boolean run = true;

        do{

            // MENU
            System.out.println("");
            System.out.println("MENU");
            System.out.println("=====================");
            System.out.println("1. List all employees");
            System.out.println("2. Get employee by id");
            System.out.println("3. Add new employee");
            System.out.println("4. Update employee");
            System.out.println("5. Delete employee");
            System.out.println("6. Exit");
            System.out.println("=====================");
            System.out.println("");

            int choice = scanner.nextInt();

            switch (choice){

                case 1:
                    EmployeeRepository.listAllEmployees();
                    break;
                case 2:
                    System.out.println("Type employee id:");
                    Long id = scanner.nextLong();

                    EmployeeRepository.listEmployeeById(id);
                    break;
                case 3:
                    controller.addNewEmployee();
                    break;
                case 4:
                    System.out.println("Eddit employee");
                    System.out.println("Type employee id:");
                    Long idToUpdate = scanner.nextLong();

                    EmployeeRepository.listEmployeeById(idToUpdate);

                    System.out.println("First Name: ");
                    String firstName_ = scanner.next();
                    System.out.println("Last Name: ");
                    String lastName_ = scanner.next();
                    System.out.println("Salary1: ");
                    double salary1_ = scanner.nextDouble();
                    System.out.println("Salary2: ");
                    String salary2String_ = scanner.next();
                    System.out.println("City: ");
                    String locality_ = scanner.next();
                    System.out.println("Zip Code: ");
                    String zipCode_ = scanner.next();
                    System.out.println("Street: ");
                    String street_ = scanner.next();
                    System.out.println("House number: ");
                    int streetNumber_ = scanner.nextInt();

                    Employee employeeToMerge = new Employee(firstName_, lastName_, salary1_, salary2String_, locality_, zipCode_, street_, streetNumber_);
                    employeeToMerge.setId(idToUpdate);

                    EmployeeRepository.editExistingEmployeeFromCLI(employeeToMerge);

                    break;
                case 5:
                    System.out.println("Chose record to delete");
                    System.out.println("Type employee id:");
                    Long idToDelete = scanner.nextLong();

                    EmployeeRepository.deleteEmployee(idToDelete);
                    break;
                case 6:
                    System.out.println("bye!");
                    run = false;
                    break;
            }

        }while(run);
        // Closing of connection
        if(entityManager.isOpen() | entityManagerFactory != null){
            JPAUtils.closeConnection();
        }
    }
}
