package com.mitrais;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Main {

    private final static int MAX_LENGTH = 30;
    private static String buffer = "";
    private static final int N = 100;

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;

        System.out.println("Juice size = " + juice.size);

        Puppy tommyPuppy = new Puppy("Tommy");
        tommyPuppy.SetAge(2);
        System.out.println("Age of Tommy puppy = " + tommyPuppy.GetAge());

        countTo_N_Improved();

        StringBuffer sb = new StringBuffer("hello");
        sb.append("world");
        sb.insert(0, " Tutorialspoint");
        System.out.print(sb);

        long startTime = System.currentTimeMillis();

        for(int i=0;i<50000;i++) {
            String s1 = "hello";
            String s2 = "hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken for creation"
                + " of String literals : "+ (endTime - startTime)
                + " milli seconds" );
        long startTime1 = System.currentTimeMillis();

        for(int i=0;i<50000;i++) {
            String s3 = new String("hello");
            String s4 = new String("hello");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time taken for creation"
                + " of String objects : " + (endTime1 - startTime1)
                + " milli seconds");

        Date date = new Date();
        String strDateFormat = "HH:mm:ss a";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(date));

        Date d1 = new Date();
        Calendar cl = Calendar. getInstance();
        cl.setTime(d1);

        System.out.println("today is " + cl.WEEK_OF_YEAR+ " week of the year");
        System.out.println("today is a "+cl.DAY_OF_MONTH + "month of the year");
        System.out.println("today is a "+cl.WEEK_OF_MONTH +"week of the month");



        int a, b;
        a = 10;
        b = (a == 1) ? 20: 30;
        System.out.println( "Value of b is : " +  b );

        b = (a == 10) ? 20: 30;
        System.out.println( "Value of b is : " + b );

        methodRankPoints(255.7);

        int c = 30;
        int d = 45;
        System.out.println("Before swapping, a = " + c + " and b = " + d);

        // Invoke the swap method
        swapFunction(a, b);
        System.out.println("\n**Now, Before and After swapping values will be same here**:");
        System.out.println("After swapping, a = " + c + " and b is " + d);

        int e = 11;
        int f = 6;
        double g = 7.3;
        double h = 9.4;
        int result1 = minFunction(e, f);

        // same function name with different parameters
        double result2 = minFunction(g, h);
        System.out.println("Minimum Value = " + result1);
        System.out.println("Minimum Value = " + result2);


        printMax(34, 3, 3, 2, 56.5);
        printMax(new double[]{1, 2, 3});

    }

    private static class FreshJuice {
        enum FreshJuiceSize { SMALL, MEDIUM, LARGE }
        FreshJuiceSize size;
    }

    private static class Puppy {
        int puppyAge;

        Puppy(String name){
            System.out.println("Puppy Name: " + name);
        }

        void SetAge(int age){
            puppyAge = age;
        }

        int GetAge(){
            System.out.println("Puppy age is =" + puppyAge);
            return  puppyAge;
        }
    }

    private static void emit(String nextChunk) {
        if(buffer.length() + nextChunk.length() > MAX_LENGTH) {
            System.out.println(buffer);
            buffer = "";
        }
        buffer += nextChunk;
    }

    private static void countTo_N_Improved() {
        for (int count = 2; count<= N; count = count+2) {
            emit(" " + count);
        }
    }

    private static void printArray(String message, int array[]) {
        System.out.println(message + ": [length: " + array.length + "]");

        for (int i = 0; i < array.length; i++) {
            if(i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void methodRankPoints(double points) {
        if (points >= 202.5) {
            System.out.println("Rank:A1");
        }else if (points >= 122.4) {
            System.out.println("Rank:A2");
        }else {
            System.out.println("Rank:A3");
        }
    }

    public static void swapFunction(int a, int b) {
        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);

        // Swap n1 with n2
        int c = a;
        a = b;
        b = c;
        System.out.println("After swapping(Inside), a = " + a + " b = " + b);
    }

    // for integer
    public static int minFunction(int n1, int n2) {
        int min;
        if (n1 > n2)
            min = n2;
        else
            min = n1;

        return min;
    }

    // for double
    public static double minFunction(double n1, double n2) {
        double min;
        if (n1 > n2)
            min = n2;
        else
            min = n1;

        return min;
    }

    public static void printMax( double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }

        double result = numbers[0];

        for (int i = 1; i <  numbers.length; i++)
            if (numbers[i] >  result)
                result = numbers[i];
        System.out.println("The max value is " + result);
    }
}
