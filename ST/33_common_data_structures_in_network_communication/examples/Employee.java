import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Do not forget to check out the CSV, XML, JSON and YAML representation of the created list of objects
public class Employee {
    private long id;
    private String name;
    private String surName;
    private int age;
    private char gender;
    private String email;
    private String department;
    private List<String> skills;
    private long managerId;

    // Constructor, getters, setters
    public Employee(long id, String name, String surName, int age, char gender, String email, String department, List<String> skills, long managerId) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.department = department;
        this.skills = skills;
        this.managerId = managerId;
    }

    // Getters and setters
    // Please note: setters are not included for brevity

    public static void main(String[] args) {
        // Creating list of employees
        List<Employee> employees = new ArrayList<>();
        // Assuming the third employee has id 3
        long managerId = 3;
        employees.add(new Employee(1, "John", "Doe", 30, 'M', "john@example.com", "Engineering", List.of("Java", "Python"), managerId));
        employees.add(new Employee(2, "Jane", "Smith", 28, 'F', "jane@example.com", "Marketing", List.of("Marketing Strategy", "Social Media"), managerId));
        employees.add(new Employee(3, "Bob", "Johnson", 35, 'M', "bob@example.com", "Finance", List.of("Accounting", "Financial Analysis"), 0));

        // Serialize to CSV
        try {
            CsvMapper csvMapper = new CsvMapper();
            File csvFile = new File("Employee.csv");
            csvMapper.writerFor(List.class)
                    .with(csvMapper.schemaFor(Employee.class).withHeader())
                    .writeValue(csvFile, employees);
            System.out.println("CSV serialization successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Serialize to JSON
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new File("Employee.json");
            objectMapper.writeValue(jsonFile, employees);
            System.out.println("JSON serialization successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Serialize to XML
        try {
            XmlMapper xmlMapper = new XmlMapper();
            File xmlFile = new File("Employee.xml");
            xmlMapper.writeValue(xmlFile, employees);
            System.out.println("XML serialization successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Serialize to YAML
        try {
            YAMLMapper yamlMapper = new YAMLMapper();
            File yamlFile = new File("Employee.yaml");
            yamlMapper.writeValue(yamlFile, employees);
            System.out.println("YAML serialization successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}