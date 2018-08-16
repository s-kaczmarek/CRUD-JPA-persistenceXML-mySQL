package domain;

import javax.persistence.*;
import java.math.BigDecimal;

// adnotacja "@Entity" wskazuje, ze ta klasa jest encją
@Entity
// adnotacja "@Table" wskazuje do której tabeli mają zostać zapisane dane z tej klasy
@Table(name = "Pracownicy")
// adnotacja "@SecondaryTable" określa drugą tabelę do której będziemy dodawać dane
// "pkJoinColumns" = zmieniamy nazwę gkucza obcego 
@SecondaryTable(name = "Adresy", pkJoinColumns = @PrimaryKeyJoinColumn(name = "employeeId"))
public class Employee {

    // adnotacja "@Id" wskazuje, które pole będzie kluczem głównym w tabeli.
    @Id
    // adnotacja "@GeneratedValue" określa autoinkrementację wartości.
    @GeneratedValue
    private long id;

    // określamy nazwę tworzonej kolumny,
    // nullable = false oznacza, że imię musi być zawsze podane,
    // length = 10 oznacza, że imię nie może być dłuższe niż 10 znaków.
    @Column(name = "imie", nullable = false, length = 10)
    private String firstName;

    // columnDefinition podobnie jak wyżej określa, że wartość nie może przekraczać 10 znaków i nie może być nullem.

    @Column(name = "nazwisko", columnDefinition = "VARCHAR(10) NOT NULL")
    private String lastName;
    @Column(name = "pensja")
    private double salary1;

    // "precision" określa ile dokładnie cyfr ma mieć wartość,
    // "scale" określa ile maksymalnie miejsc po przecinku moze mieć wartość
    @Column(name = "pensja2", precision = 10, scale = 2)
    private BigDecimal salary2;

    @Column(table = "Adresy", name = "miejscowosc")
    private String locality;
    @Column(table = "Adresy", name = "kodPocztowy")
    private String zipCode;
    @Column(table = "Adresy", name = "ulica")
    private String street;
    @Column(table = "Adresy", name = "numerDomu")
    private int streetNumber;

    // Bezargumentowy konstruktor jest wymagany przez hibernate w celu wykonywania custom query
    public Employee(){}

    public Employee(String firstName,
                    String lastName,
                    double salary1,
                    String salary2String,
                    String locality,
                    String zipCode,
                    String street,
                    int streetNumber ){

        this.firstName = firstName;
        this.lastName = lastName;
        this.salary1 = salary1;
        this.salary2 = new BigDecimal(salary2String);
        this.locality = locality;
        this.zipCode = zipCode;
        this.street = street;
        this.streetNumber = streetNumber;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary1=" + salary1 +
                ", salary2=" + salary2 +
                ", locality='" + locality + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                '}';
    }

    // Wymagane gettery i settery:

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary1;
    }

    public void setSalary(double salary) {
        this.salary1 = salary;
    }

    public BigDecimal getSalary2() {
        return salary2;
    }

    public void setSalary2(BigDecimal salary2) {
        this.salary2 = salary2;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
}
