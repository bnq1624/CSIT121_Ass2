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

class WorksOn implements DataIO {
    // data member
    private Project proj;
    private Developer emp;
    private int hours;

    // default constructor
    public WorksOn() {
        proj = new Project();
        emp = new Developer();
        hours = 0;
    }

    // constructor with 3 parameters
    public WorksOn(Project proj, Developer emp, int hours) {
        this.proj = proj;
        this.emp = emp;
        this.hours = hours;
    }

    public Project getProj() {
        return proj;
    }

    public Developer getEmp() {
        return emp;
    }

    public void dataInput(Scanner input) {
        proj.dataInput(input);
        emp.dataInput(input);
        hours = input.nextInt();
    }

    public void dataOutput(Formatter output) {
        proj.dataOutput(output);
        emp.workonOutput(output);
        output.format("%d\n", hours);
    }

    public String toString() {
        return proj.toString() + "\n" + "Developer " + emp.toString() + "\n Hours: " + hours + "\n";
    }
}