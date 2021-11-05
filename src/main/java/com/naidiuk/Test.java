package com.naidiuk;

public class Test {
    public static void main(String[] args) {
        String str = "Егор - Алла - Александр";
        String[] strings = str.split("\\s");
        for (String s : strings) {
            if (!s.equals("-")) {
                System.out.println(s);
            }
        }
    }
}
