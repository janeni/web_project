package com.sunjx.java.ref;

/**
 * Created by jx on 2017/6/10.
 */
public class RefDemo02 {
    public static void main(String[] args) {
        String str1="Hello";
        System.out.println(str1);
        print(str1);
        System.out.println(str1);
    }
    public static void print(String str2){
        str2="haha";

    }
}
