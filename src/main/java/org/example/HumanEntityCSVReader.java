package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;
import com.opencsv.exceptions.CsvValidationException;

/**
 * This class reads Person objects from a CSV file.
 */
public class HumanEntityCSVReader {
    /**
     * Reads Person objects from a CSV file with the specified file path and separator character.
     *
     * @param filepath the file path of the CSV file
     * @param separator the separator character used in the CSV file
     * @return a list of Person objects read from the CSV file
     */
    public ArrayList<HumanEntity> extractFromCSV(String filepath, char separator) {
        ArrayList<HumanEntity> humanEntityList = new ArrayList<>();

        try (InputStream in = getClass().getClassLoader().getResourceAsStream(filepath)) {
            try (CSVReader reader = in == null ? null : new CSVReaderBuilder(new InputStreamReader(in))
                    .withCSVParser(new CSVParserBuilder().withSeparator(separator).build())
                    .build()) {
                String[] nextLine;
                reader.readNext(); // Skip header row
                while ((nextLine = reader.readNext()) != null) {
                    int id = Integer.parseInt(nextLine[0]);
                    String name = nextLine[1];
                    String gender = nextLine[2];
                    String birthDate = nextLine[3];
                    DepartmentEntity department = DepartmentEntity.fetchDepartment(nextLine[4]);
                    double salary = Double.parseDouble(nextLine[5]);
                    HumanEntity humanEntity = new HumanEntity(id, name, gender, department, salary, birthDate);
                    humanEntityList.add(humanEntity);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return humanEntityList;
    }
}

