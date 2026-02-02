package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};

        //명령형
        for (int i =0;i< arr.length;i++){
            System.out.println(arr[i]);
        }

        //선언형
        Arrays.stream(arr)
                .forEach(System.out::println);

        //함수 ();-> 함수 실행
        //함수 -> 함수 자체 
    }
}