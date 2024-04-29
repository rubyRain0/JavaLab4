package org.example;

import java.util.List;

/**
 * The Main class is the entry point of the application.
 * It reads a list of persons from a CSV file and prints their details to the console.
 */
public class Main {

    /**
     * The main method reads a list of persons from a CSV file and prints their details to the console.
     *
     * @param args command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        HumanEntityCSVReader humanReader = new HumanEntityCSVReader();

        List<HumanEntity> humanList = humanReader.extractFromCSV("foreign_names.csv", ';');

        printPersonDetails(humanList);
    }

    /**
     * Prints the details of each person in the given list to the console.
     *
     * @param personList the list of persons to print
     */
    private static void printPersonDetails(List<HumanEntity> personList) {
        for (HumanEntity human : personList) {
            System.out.printf("ID: %d; name: %s; gender: %s; department: %d.%s; salary: %.2f; birth date: %s%n",
                    human.getPersonId(),
                    human.getPersonName(),
                    human.getPersonGender(),
                    human.getAssociatedDepartment().getDepartmentId(),
                    human.getAssociatedDepartment().getDepartmentName(),
                    human.getAnnualSalary(),
                    human.getDateOfBirth());
        }
    }
}

