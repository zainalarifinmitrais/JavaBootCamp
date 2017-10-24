package com.mitrais;

public class Main {

    private final static int MAX_LENGTH = 30;
    private static String buffer = "";
    private static final int N = 100;

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
        Employee emp = new Employee();
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
}
