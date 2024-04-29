package org.example;

import java.util.HashMap;

/**
 * This class represents a Department.
 */
public class DepartmentEntity {

    private static HashMap<String, DepartmentEntity> departmentRepository = new HashMap<>();
    private final int departmentId;
    private final String departmentName;
    private static int nextIdentifier = 1;

    /**
     * Constructs a DepartmentEntity object with the specified id and name.
     *
     * @param id the id of the department
     * @param name the name of the department
     */
    public DepartmentEntity(int id, String name) {
        this.departmentId = id;
        this.departmentName = name;
    }

    /**
     * Returns the name of the department.
     *
     * @return the name of the department
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Returns the id of the department.
     *
     * @return the id of the department
     */
    public int getDepartmentId() {
        return departmentId;
    }

    /**
     * Retrieves a DepartmentEntity object from the repository. If the department does not exist, it is created and added to the repository.
     *
     * @param name the name of the department
     * @return the DepartmentEntity object
     */
    public static DepartmentEntity fetchDepartment(String name) {
        if (departmentRepository.containsKey(name)) {
            return departmentRepository.get(name);
        } else {
            DepartmentEntity department = new DepartmentEntity(nextIdentifier++, name);
            departmentRepository.put(name, department);
            return department;
        }
    }

}