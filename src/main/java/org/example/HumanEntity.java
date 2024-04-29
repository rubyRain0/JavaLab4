package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * This class represents a Person.
 */
public class HumanEntity {
    /**
     * The id of the person.
     */
    private int personId;

    /**
     * The name of the person.
     */
    private String personName;

    /**
     * The gender of the person.
     */
    private String personGender;

    /**
     * The department associated with the person.
     */
    private DepartmentEntity associatedDepartment;

    /**
     * The annual salary of the person.
     */
    private double annualSalary;

    /**
     * The birthdate of the person.
     */
    private LocalDate dateOfBirth;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * Constructs a HumanEntity object with the specified parameters.
     *
     * @param id the id of the person
     * @param name the name of the person
     * @param gender the gender of the person
     * @param department the department associated with the person
     * @param salary the annual salary of the person
     * @param birthDate the birthdate of the person in "dd-MM-yyyy" format
     */
    public HumanEntity(int id, String name, String gender, DepartmentEntity department, double salary, String birthDate) {
        this.personId = id;
        this.personName = name;
        this.personGender = gender;
        this.associatedDepartment = department;
        this.annualSalary = salary;
        this.dateOfBirth = LocalDate.parse(birthDate, DATE_FORMATTER);
    }
    /**
     * Returns the annual salary of the person.
     *
     * @return the annual salary of the person
     */
    public double getAnnualSalary() {
        return annualSalary;
    }

    /**
     * Returns the birthdate of the person.
     *
     * @return the birthdate of the person
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * Returns the id of the person.
     *
     * @return the id of the person
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * Returns the gender of the person.
     *
     * @return the gender of the person
     */
    public String getPersonGender() {
        return personGender;
    }

    /**
     * Returns the department associated with the person.
     *
     * @return the department associated with the person
     */
    public DepartmentEntity getAssociatedDepartment() {
        return associatedDepartment;
    }
}
