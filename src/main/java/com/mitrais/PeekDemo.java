package com.mitrais;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PeekDemo {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("1","1","2","3","4");

        stringList.stream()
                .limit(2)
                .peek(System.out::println);

        IntStream.rangeClosed(1, 5)
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}
