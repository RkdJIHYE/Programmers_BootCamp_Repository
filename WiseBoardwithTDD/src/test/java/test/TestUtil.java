package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class TestUtil {

//    public static String run(String input){
//        //입력값 input 을 -> 배열에 저장해주고
//
//        //입력값
//        Scanner sc = new Scanner(input);
//
//
//        //명언 프로그램 실행
//
//
//        //출력값
//    }

    private static PrintStream originalStream = System.out;
    private static PrintStream currentStream = System.out;

    public static ByteArrayOutputStream setOutByteArray(){


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        //배열로 쌓이도록 함
        System.setOut(printStream);
        currentStream = printStream;
        return byteArrayOutputStream;
    }

    public static void ClearSetOut(ByteArrayOutputStream outputStream) throws IOException {

        System.setOut(originalStream);
        outputStream.close();
        currentStream.close();
    }
    public static Scanner getScanner(String input){
        return new Scanner(input);
    }
}
