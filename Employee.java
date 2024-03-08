/*------------------------------------------------------
 My name: Quy Binh Nguyen
 My student number: 7613623
 My course code: CSIT121
 My email address: qbinhhh164@gmail.com / qbn774@uowmail.edu.au
 Assignment number: 2
-------------------------------------------------------*/ 

import java.io.*;
import java.nio.*;
import java.util.*;

class Employee implements DataIO {
    // data member
    private int eNumber;
    private String eName;
    private String dob;
    private String address;
    private String gender;
    private double salary;
    private int supervisor;
    private int dNumber;

    // default constructor
    public Employee() {
        eNumber = supervisor = dNumber = 0;
        eName = dob = address = gender = "";
        salary = 0.0;
    }

    // constructor with 8 parameters
    public Employee(int eNumber, String eName, String dob, String address, String gender, double salary, int supervisor, int dNumber) {
        this.eNumber = eNumber;
        this.eName = eName;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.salary = salary;
        this.supervisor = supervisor;
        this.dNumber = dNumber;
    }
    
    // get eNumber
    public int getENumber() {
        return eNumber;
    }

    public void dataInput(Scanner input) {
        eNumber = input.nextInt();
        eName = input.next();
        dob = input.next();
        address = input.next();
        gender = input.next();
        salary = input.nextDouble();
        supervisor = input.nextInt();
        dNumber = input.nextInt();
    }

    public void dataOutput(Formatter output) {
        output.format("%d, %s, %s, %s, %s, %f, %d, %d, ", eNumber, eName, dob, address, gender, salary, supervisor, dNumber);
    }

    public String toString() {
        return "Employee number: " + eNumber + ", Employee name: " + eName + ", Date of birth: " + dob
               + ", Address: " + address + ", Gender: " + gender + ", Salary: " + salary + ", Supervisor number: "
               + supervisor + ", Department number: " + dNumber;
    }
}

class Admin extends Employee implements DataIO {
    private String skills;

    // default constructor
    public Admin() {
        super();
        skills = "";
    }

    // constructor with 9 parameters
    public Admin(int eNumber, String eName, String dob, String address, String gender, double salary, int supervisor, int dNumber, String skills) {
        super(eNumber, eName, dob, address, gender, salary, supervisor, dNumber);
        this.skills = skills;
    }

    public void dataInput(Scanner input) {
        super.dataInput(input);
        skills = input.next();
    }

    public void dataOutput(Formatter output) {
        // output as an admin
        output.format("%s, ", "A");

        super.dataOutput(output);

        // display skills
        output.format("%s\n", skills);
    }

    public void workonOutput(Formatter output) {
        super.dataOutput(output);

        // display skills
        output.format("%s\n", skills);
    }

    public String toString() {
        return super.toString() + ", Skills: " + skills;
    }
}

class Developer extends Employee implements DataIO {
    private String language;

    // default constructor
    public Developer() {
        super();
        language = "";
    }

    // constructor with 9 parameters
    public Developer(int eNumber, String eName, String dob, String address, String gender, double salary, int supervisor, int dNumber, String language) {
        super(eNumber, eName, dob, address, gender, salary, supervisor, dNumber);
        this.language = language;
    }

    public void dataInput(Scanner input) {
        super.dataInput(input);
        language = input.next();
    }

    public void dataOutput(Formatter output) {
        // output as a developer
        output.format("%s, ", "D");

        super.dataOutput(output);

        // display programming language
        output.format("%s\n", language);
    }

    public void workonOutput(Formatter output) {
        super.dataOutput(output);

        // display programming language
        output.format("%s\n", language);
    }

    public String toString() {
        return super.toString() + ", Languages: " + language;
    }
}