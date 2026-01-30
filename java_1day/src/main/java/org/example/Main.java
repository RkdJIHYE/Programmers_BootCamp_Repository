package org.example;

//메인 함수 생성
//코드는 항상 메인 함수 안에 넣을 것
//파일 이름과 클래스 이름이 같아야 한다.
//(Main.java == class Main)
public class Main {
    public static void main(String[] args) {

        int[] arr = new int[3];

        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        // 배열 깊은 복사
        int[] arr2 = new int[3];
        for(int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }


        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr2[i]);  // 10 20 30
        }

        arr2[0] = 100;

        for(int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);  // 100 20 30
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);  // 10 20 30
        }
    }
}
