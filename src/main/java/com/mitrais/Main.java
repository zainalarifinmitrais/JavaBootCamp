package com.mitrais;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello World!");
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;
        System.out.println("Juice size = " + juice.size);

        Puppy tommyPuppy = new Puppy("Tommy");
        tommyPuppy.SetAge(2);
        System.out.println("Age of Tommy puppy = " + tommyPuppy.GetAge());
    }

    static class FreshJuice {
        enum FreshJuiceSize { SMALL, MEDIUM, LARGE }
        FreshJuiceSize size;
    }

    static class Puppy {
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
}
