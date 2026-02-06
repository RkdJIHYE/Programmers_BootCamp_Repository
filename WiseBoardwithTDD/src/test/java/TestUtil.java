import java.io.ByteArrayOutputStream;
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
//
//
//
//    }

    public static ByteArrayOutputStream setOutByteArray(){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        //배열로 쌓이도록 함
        System.setOut(printStream);

        return byteArrayOutputStream;
    }

    public static Scanner getScanner(String input){
        return new Scanner(input);
    }
}
