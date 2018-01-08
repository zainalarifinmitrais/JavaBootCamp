package com.mitrais;
import java.util.function.Function;
import java.util.function.IntFunction;

public class LambdaScope {
    public LambdaScope(){
        Function<String,String> func1 = x -> {System.out.println(this);return x ;};
        System.out.println(func1.apply(""));
    }
    public String toString(){
        return "LambdaScope";
    }
    public static void main(String[] argv) {
        new LambdaScope();

        Function<String,String> func1 = y -> {
            for(int i=0;i<10;i++){
                System.out.println(i);
                if(i == 4){
                    break;
                }
            }
            return y + " from java2s.com" ;
        };
        System.out.println(func1.apply("hi"));

        final String x = "Hello";
        Function<String,String> func2 = y -> {return y + " "+ x ;};
        System.out.println(func2.apply("java2s.com"));

        IntFunction<Long> factorialCalc = Main::factorial;
        System.out.println(factorialCalc.apply(10));
    }


}


