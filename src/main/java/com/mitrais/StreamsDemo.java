package com.mitrais;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> o = numbers.stream()
                .findFirst();
        if(o.isPresent()){
            System.out.println(o.get());
        }else{
            System.out.println("no value");
        }

        EmployeeStream.persons()
                .stream()
                .filter(EmployeeStream::isFemale)
                .map(EmployeeStream::getName)
                .forEach(System.out::println);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> result = list
                .stream().parallel()
                .filter(num -> num > 4).findAny();

        if(result.isPresent()){System.out.println( result.get());}
        else {System.out.println("no value");}

        List<Integer> numbers1  = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers1.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

        int max = numbers1.stream().reduce(0,Integer::max);
        System.out.print(max);

        int min = numbers1.stream().reduce(1,Integer::min);
        System.out.println(min);

        double sum1 = EmployeeStream
                .persons()
                .stream()
                .reduce(
                        0.0,
                        (Double partialSum, EmployeeStream p) -> {
                            double accumulated = partialSum + p.getIncome();
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Accumulator: partialSum  = " + partialSum
                                    + ",  person = " + p + ", accumulated = " + accumulated);
                            return accumulated;
                        },
                        (a, b) -> {
                            double combined = a + b;
                            System.out.println(Thread.currentThread().getName()
                                    + "  - Combiner:  a  = " + a + ", b  = " + b
                                    + ", combined  = " + combined);
                            return combined;
                        });
        System.out.println("--------------------------------------");
        System.out.println(sum1);

    }
}

class EmployeeStream {
    public static enum Gender {
        MALE, FEMALE
    }

    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    public EmployeeStream(long id, String name, Gender gender, LocalDate dob,
                    double income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isMale() {
        return this.gender == Gender.MALE;
    }

    public boolean isFemale() {
        return this.gender == Gender.FEMALE;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public static List<EmployeeStream> persons() {
        EmployeeStream p1 = new EmployeeStream(1, "Jake", Gender.MALE, LocalDate.of(1971,
                Month.JANUARY, 1), 2343.0);
        EmployeeStream p2 = new EmployeeStream(2, "Jack", Gender.MALE, LocalDate.of(1972,
                Month.JULY, 21), 7100.0);
        EmployeeStream p3 = new EmployeeStream(3, "Jane", Gender.FEMALE, LocalDate.of(1973,
                Month.MAY, 29), 5455.0);
        EmployeeStream p4 = new EmployeeStream(4, "Jode", Gender.MALE, LocalDate.of(1974,
                Month.OCTOBER, 16), 1800.0);
        EmployeeStream p5 = new EmployeeStream(5, "Jeny", Gender.FEMALE, LocalDate.of(1975,
                Month.DECEMBER, 13), 1234.0);
        EmployeeStream p6 = new EmployeeStream(6, "Jason", Gender.MALE, LocalDate.of(1976,
                Month.JUNE, 9), 3211.0);

        List<EmployeeStream> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        return persons;
    }

    @Override
    public String toString() {
        String str = String.format("(%s, %s,  %s,  %s,  %.2f)\n", id, name, gender,
                dob, income);
        return str;
    }
}
