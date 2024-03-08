/*------------------------------------------------------
 My name: Quy Binh Nguyen
 My student number: 7613623
 My course code: CSIT121
 My email address: qbinhhh164@gmail.com / qbn774@uowmail.edu.au
 Assignment number: 2
-------------------------------------------------------*/ 

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DEP {
    // data member
    private ArrayList<Department> depts;
    private ArrayList<Employee> emps;
    private ArrayList<Project> projs;
    private ArrayList<WorksOn> works;

    // default constructor
    public DEP() {
        depts = new ArrayList<Department>();
        emps = new ArrayList<Employee>();
        projs = new ArrayList<Project>();
        works = new ArrayList<WorksOn>();
    }

    // main method
    public static void main(String[] args) {
        DEP dep = new DEP();

        dep.inputSection();
    }

    public void inputSection() {
        loadDepartments();
        loadEmployees();
        loadProjects();
        loadWorksOn();

        Scanner input = new Scanner(System.in);
        boolean done = false;

        while(!done) {
            displayMenu();
            int userInput = input.nextInt();

            switch(userInput) {
                case 1:
                    displayDepartments();
                    break;
    
                case 2:
                    displayEmployees();
                    break;
    
                case 3:
                    displayProjects();
                    break;
    
                case 4:
                    displayWorksOn();
                    break;
    
                case 5:
                    addDepartment();
                    break;
    
                case 6:
                    addEmployee();
                    break;
    
                case 7:
                    addProject();
                    break;
    
                case 8:
                    addWorksOn();
                    break;
    
                case 9:
                    saveDepartments();
                    saveEmployees();
                    saveProjects();
                    saveWorksOn();
    
                    System.out.println("Data saved.");
                    break;
    
                case 0:
                    System.out.print("Bye-bye");
                    done = true;
                    break;
    
                default:
                    System.out.println("Wrong input, please try again.");
                    displayMenu();
                    inputSection();
                    break;
            }
        }
    }

    // menu
    public void displayMenu() {
        System.out.println("1. Display all departments.");
        System.out.println("2. Display all employees.");
        System.out.println("3. Display all projects.");
        System.out.println("4. Display information for employees who works on projects.");
        System.out.println("5: Add a new department.");
        System.out.println("6: Add a new employee.");
        System.out.println("7: Add a new project.");
        System.out.println("8: Add a new works on record.");
        System.out.println("9. Save all data into files.");
        System.out.println("0. Exit.");
        System.out.print("Input a choice (0-9): ");
    }

    public boolean checkEmployee(int eNumber) {
        for(Employee e:emps) {
            if(eNumber == e.getENumber()) {
                return true;
            }
        }

        return false;
    }

    public boolean checkProject(long pNumber) {
        for(Project p:projs) {
            if(pNumber == p.getPNumber()) {
                return true;
            }
        }

        return false;
    }

    public boolean employeeHasBeenAllocated(int eNumber, long pNumber) {
        boolean allocated = false;

        for(int i=0; i<works.size(); i++) {
            if(eNumber == works.get(i).getEmp().getENumber() && pNumber == works.get(i).getProj().getPNumber()) {
                allocated = true;
                break;
            }
        }

        return allocated;
    }

    public Project findProject(long pNumber) {
        for(int i=0; i<projs.size(); i++) {
            if(pNumber == projs.get(i).getPNumber()) {
                return projs.get(i);
            }
        }

        return null;
    }

    public Developer findEmployee(int eNumber) {
        for(int i=0; i<emps.size(); i++) {
            if((eNumber == emps.get(i).getENumber()) && (emps.get(i) instanceof Developer)) {
                return (Developer)emps.get(i);
            }
        }

        return null;
    }

    // get the data from the file
    public void loadDepartments() {
        Path path = Paths.get("departments.txt");

        try {
            // if path exists, read the file
            if(Files.exists(path)) {
                Scanner input = new Scanner(path);
                input.useDelimiter(", |\r\n|\n");

                while(input.hasNext()) {
                    Department department = new Department();

                    department.dataInput(input);
                    depts.add(department);
                }
                
            }

        // the code will be executed if try{} cause an exception
        }catch(IOException err) {
            System.out.println("This file does not exist.");
        }
    }

    // display departments
    public void displayDepartments() {
        for(Department d:depts) {
            System.out.println(d.toString());
        }
    }

    public void loadEmployees() {
        Path path = Paths.get("employees.txt");

        try {
            // if path exists, read the file
            if(Files.exists(path)) {
                Scanner input = new Scanner(path);
                input.useDelimiter(", |\r\n|\n");

                while(input.hasNext()) {
                    String position = input.next();
                    
                    if(position.equalsIgnoreCase("A")) {
                        Admin admin = new Admin();

                        admin.dataInput(input);
                        emps.add(admin);
                    }else if(position.equalsIgnoreCase("D")) {
                        Developer developer = new Developer();

                        developer.dataInput(input);
                        emps.add(developer);
                    }
                }
                
            }

        // the code will be executed if try{} cause an exception
        }catch(IOException err) {
            System.out.println("This file does not exist.");
        }
    }

    // display employees
    public void displayEmployees() {
        for(Employee e:emps) {
            if(e instanceof Admin) {
                System.out.println("Admin " + e.toString());
            }else if(e instanceof Developer) {
                System.out.println("Developer " + e.toString());
            }
        }
    }

    public void loadProjects() {
        Path path = Paths.get("projects.txt");

        try {
            // if path exists, read the file
            if(Files.exists(path)) {
                Scanner input = new Scanner(path);
                input.useDelimiter(", |\r\n|\n");

                while(input.hasNext()) {
                    Project project = new Project();

                    project.dataInput(input);
                    projs.add(project);
                }
                
            }

        // the code will be executed if try{} cause an exception
        }catch(IOException err) {
            System.out.println("This file does not exist.");
        }
    }

    // display projects
    public void displayProjects() {
        for(Project p:projs) {
            System.out.println(p.toString());
        }
    }

    public void loadWorksOn() {
        Path path = Paths.get("workson.txt");

        try{
            // if path exists, read the file
            if(Files.exists(path)) {
                Scanner input = new Scanner(path);
                input.useDelimiter(", |\r\n|\n");

                while(input.hasNext()) {
                    WorksOn workson = new WorksOn();

                    workson.dataInput(input);
                    works.add(workson);
                }
             
            }

        // the code will be executed if try{} cause an exception
        }catch(IOException err) {
            System.out.println("This file does not exist.");
        }
    }

    // display works-on
    public void displayWorksOn() {
        for(WorksOn w:works) {
            System.out.println(w.toString());
        }
    }

    // add the new data
    public void addDepartment() {   
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.print("Department number: ");
        int dNumber = input1.nextInt();

        for(int i=0; i<depts.size(); i++) {
            if(dNumber == depts.get(i).getDNumber()) {
                System.out.println("The department " + dNumber + " exists.");
                return;
            }
        }

	    System.out.print("Department name: ");
        String dNameInput = input2.nextLine();

        System.out.print("Manager number: ");
        int managerNumberInput = input1.nextInt();

        System.out.print("Budget: ");
        double budgetInput = input1.nextDouble();

        System.out.print("Start date: ");
        String startDateInput = input1.next();

        depts.add(new Department(dNumber, dNameInput, managerNumberInput, budgetInput, startDateInput));
    }

    public void addEmployee() {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.print("Employee number: ");
        int eNumber = input2.nextInt();

        for(int i=0; i<emps.size(); i++) {
            if(eNumber == emps.get(i).getENumber()) {
                System.out.println("The employee " + eNumber + " exists.");
                return;
            }
        }
        System.out.print("Employee name: ");
        String eNameInput = input1.nextLine();

        System.out.print("Date of birth (dd/mm/yyyy): ");
        String dobInput = input2.next();

        System.out.print("Address: ");
        String addressInput = input1.nextLine();

        System.out.print("Gender: ");
        String genderInput = input2.next();

        System.out.print("Salary: ");
        double salaryInput = input2.nextDouble();

        System.out.print("Supervisor number: ");
        int supervisorNumberInput = input2.nextInt();

        System.out.print("Department number: ");
        int dNumberInput = input2.nextInt();

        System.out.print("Admin or Developer(A or D)?: ");
        String positionInput = input2.next();

        if(positionInput.equalsIgnoreCase("A")) {
            System.out.print("Skills: ");
            String skillsInput = input1.nextLine();
            emps.add(new Admin(eNumber, eNameInput, dobInput, addressInput, genderInput, salaryInput, supervisorNumberInput, dNumberInput, skillsInput));
        }else if(positionInput.equalsIgnoreCase("D")) {
            System.out.print("Languages: ");
            String languagesInput = input1.nextLine();
            emps.add(new Developer(eNumber, eNameInput, dobInput, addressInput, genderInput, salaryInput, supervisorNumberInput, dNumberInput, languagesInput));
        }
    }

    public void addProject() {
        Scanner input = new Scanner(System.in);

        System.out.print("Project number: ");
        long pNumber = input.nextLong();

        for(int i=0; i<projs.size(); i++) {
            if(pNumber == projs.get(i).getPNumber()) {
                System.out.println("The project " + pNumber + " exists.");
                return;
            }
        }
        System.out.print("Project title: ");
		input.nextLine();
        String pTitleInput = input.nextLine();

        System.out.print("Sponsor: ");
        String sponsorInput = input.nextLine();

        System.out.print("Department number: ");
        int dNumberInput = input.nextInt();

        System.out.print("Budget: ");
        double budgetInput = input.nextDouble();

        projs.add(new Project(pNumber, pTitleInput, sponsorInput, dNumberInput, budgetInput));
    }

    public void addWorksOn() {
        Scanner input = new Scanner(System.in);

        System.out.print("Employee number: ");
        int eNumber = input.nextInt();

        if(checkEmployee(eNumber)) {
            System.out.print("Project number: ");
            long pNumber = input.nextLong();

            if(checkProject(pNumber)) {

                    if(employeeHasBeenAllocated(eNumber, pNumber)) {
                        System.out.println("The employee " + eNumber + " has already been allocated to the project " + pNumber);
                    }else {
                        System.out.print("Input total hours: ");
                        int totalHours = input.nextInt();

                        WorksOn worksOnRecord = new WorksOn(findProject(pNumber), findEmployee(eNumber), totalHours);
                        works.add(worksOnRecord);
                    }

            }else {
                System.out.println("The project " + pNumber + " does not exist.");
            }

        }else {
            System.out.println("The employee " + eNumber + " does not exist.");
        }
    }
    
    // save the data
    public void saveDepartments() {
        try {
            Formatter formatter = new Formatter("departments.txt");

            for(Department d:depts) {
            d.dataOutput(formatter);
            }
            formatter.close();
        }catch(IOException e) {
            System.out.println("IO Exception error");
        }
    }

    public void saveEmployees() {
        try {
            Formatter formatter = new Formatter("employees.txt");

            for(Employee e:emps) {
                e.dataOutput(formatter);
            }
            formatter.close();
        }catch(IOException e) {
            System.out.println("IO Exception error");
        }
    }

    public void saveProjects() {
        try {
            Formatter formatter = new Formatter("projects.txt");

            for(Project p:projs) {
                p.dataOutput(formatter);
            }
            formatter.close();
        }catch(IOException e) {
            System.out.println("IO Exception error");
        }
    }

    public void saveWorksOn() {
        try {
            Formatter formatter = new Formatter("workson.txt");

            for(WorksOn w:works) {
                w.dataOutput(formatter);
            }
            formatter.close();
        }catch(IOException e) {
            System.out.println("IO Exception error");
        }
    }
}