package org.example;

import com.opencsv.exceptions.CsvValidationException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains test methods for the HumanEntityCSVReader class.
 * It tests the functionality of reading human entities from a CSV file.
 */
class HumanEntityCSVReaderTests {

    /**
     * This method tests the readFromCSV method of the HumanEntityCSVReader class.
     * It checks if the method correctly reads and parses the data from a CSV file.
     *
     * @throws IOException             if an I/O error occurs
     * @throws CsvValidationException if a CSV validation error occurs
     */
    @Test
    void testReadFromCSV() throws IOException, CsvValidationException {
        HumanEntityCSVReader reader = new HumanEntityCSVReader();

        List<HumanEntity> humanEntities = reader.extractFromCSV("test_data.csv", ';');

        List<HumanEntity> expectedHumanEntities = new ArrayList<>();
        expectedHumanEntities.add(new HumanEntity(54177, "Zyana", "Female","08.07.1934", DepartmentEntity.fetchDepartment("O"), 8900));
        expectedHumanEntities.add(new HumanEntity(54178, "Zyta", "Female", "16.04.1955", DepartmentEntity.fetchDepartment("H"), 7600));

        assertEntityEquals(expectedHumanEntities, humanEntities);
    }

    /**
     * This method tests the readFromCSV method of the HumanEntityCSVReader class
     * when the CSV file is empty.
     * It checks if the method correctly returns an empty list when the CSV file is empty.
     *
     * @throws IOException             if an I/O error occurs
     * @throws CsvValidationException if a CSV validation error occurs
     */
    @Test
    void testReadFromEmptyCSV() throws IOException, CsvValidationException {
        HumanEntityCSVReader reader = new HumanEntityCSVReader();

        List<HumanEntity> humanEntities = reader.extractFromCSV("empty_test_data.csv", ';');

        List<HumanEntity> expectedHumanEntities = new ArrayList<>();

        assertEquals(expectedHumanEntities, humanEntities);
    }

    /**
     * This method is a custom assertion method to check the equality of two HumanEntity lists.
     * It checks if the lists have the same size and if each HumanEntity object in the lists are equal.
     *
     * @param expected the expected list of HumanEntity objects
     * @param actual   the actual list of HumanEntity objects
     */
    private void assertEntityEquals(List<HumanEntity> expected, List<HumanEntity> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            HumanEntity expectedHumanEntity = expected.get(i);
            HumanEntity actualHumanEntity = actual.get(i);
            assertEquals(expectedHumanEntity.getPersonId(), actualHumanEntity.getPersonId());
            assertEquals(expectedHumanEntity.getPersonName(), actualHumanEntity.getPersonName());
            assertEquals(expectedHumanEntity.getPersonGender(), actualHumanEntity.getPersonGender());
            assertEquals(expectedHumanEntity.getDateOfBirth(), actualHumanEntity.getDateOfBirth());
            assertEquals(expectedHumanEntity.getAssociatedDepartment().getDepartmentName(), actualHumanEntity.getAssociatedDepartment().getDepartmentName());
            assertEquals(expectedHumanEntity.getAssociatedDepartment().getDepartmentId(), actualHumanEntity.getAssociatedDepartment().getDepartmentId());
            assertEquals(expectedHumanEntity.getAnnualSalary(), actualHumanEntity.getAnnualSalary());
        }
    }
}
