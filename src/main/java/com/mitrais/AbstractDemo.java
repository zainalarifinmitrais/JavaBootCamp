package com.mitrais;

public class AbstractDemo {
    public static void main(String [] args) {
        Salary3 s = new Salary3("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee3 e = new Salary3("John Adams", "Boston, MA", 2, 2400.00);
        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();
        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
    }
}
