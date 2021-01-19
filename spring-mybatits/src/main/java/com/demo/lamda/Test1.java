package com.demo.lamda;

import java.util.Optional;

public class Test1 {
    public static void main(String[] args) {
                 useConverter(Integer::parseInt);
        String name = "John";
        Optional<String> emptyOpt = Optional.ofNullable(name);
        emptyOpt.get();
             }
     static void useConverter(Converter con) {
                 int a=con.convert("34");
                 System.out.println(a);
             }

}
