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

class Project implements DataIO {
    // data member
    private long pNumber;
    private String title;
    private String sponsor;
    private int dNumber;
    private double budget;

    // default constructor
    public Project() {
        pNumber = 0;
        dNumber = 0;
        budget = 0.0;
        title = sponsor = "";
    }

    // constructor with 5 parameters
    public Project(long pNumber, String title, String sponsor, int dNumber, double budget) {
        this.pNumber = pNumber;
        this.title = title;
        this.sponsor = sponsor;
        this.dNumber = dNumber;
        this.budget = budget;
    }

    // return pNumber
    public long getPNumber() {
        return pNumber;
    }

    public void dataInput(Scanner input) {
        pNumber = input.nextLong();
        title = input.next();
        sponsor = input.next();
        dNumber = input.nextInt();
        budget = input.nextDouble();
    }

    public void dataOutput(Formatter output) {
        output.format("%d, %s, %s, %d, %f\n", pNumber, title, sponsor, dNumber, budget);
    }

    public String toString() {
        return "Project number: " + pNumber + ", Project title: " + title + ", Sponsor: "
               + sponsor + ", Department number: " + dNumber + ", Project budget: " + budget;
    }
}
