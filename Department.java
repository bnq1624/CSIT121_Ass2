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

class Department implements DataIO {
    // data member
    private int dNumber;
    private String dName;
    private int manager;
    private double budget;
    private String startDate;

    // default constructor
    public Department() {
        dNumber = manager = 0;
        budget = 0.0;
        dName = startDate = "";
    }

    // constructor with 5 parameters
    public Department(int dNumber, String dName, int manager, double budget, String startDate) {
        this.dNumber = dNumber;
        this.dName = dName;
        this.manager = manager;
        this.budget = budget;
        this.startDate = startDate;
    }

    // return dNumber
    public int getDNumber() {
        return dNumber;
    }

    public void dataInput(Scanner input) {
        dNumber = input.nextInt();
        dName = input.next();
        manager = input.nextInt();
        budget = input.nextDouble();
        startDate = input.next();
    }

    public void dataOutput(Formatter output) {
        output.format("%d, %s, %d, %f, %s\n", dNumber, dName, manager, budget, startDate);
    }

    public String toString() {
        return "Department number: " + dNumber + ", Department name: " + dName + ", Manager number: " 
               + manager + ", Budget: " + budget + ", Manager start date: " + startDate;
    }
}