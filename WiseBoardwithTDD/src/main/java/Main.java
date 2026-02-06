import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       lab2();
    }

    public static void lab2(){
        PrintStream Original_out = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        System.out.println("hihi");
        System.out.println("byebye");
        System.out.println("ok");

        System.setOut(Original_out);

        System.out.println(byteArrayOutputStream);

    }


    public static void lab1(){
        Scanner sc = new Scanner ("""
                    등록
                    과거에 집착하지 마라.
                    작자미상
                """);

        String input = sc.nextLine();
        String input2 = sc.nextLine();
        String input3 = sc.nextLine();

        System.out.println(input);
        System.out.println(input2);
        System.out.println(input3);

    }
}
