import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //스캐너를 이용하여, 키보드에 입력을 받는다.
        Scanner sc = new Scanner(System.in);

        //1단계
        System.out.println("==명언 탭==");
        System.out.print("명령) ");
        String cmd = sc.nextLine();

        System.out.println(cmd);

        //2단계 (등록)

        System.out.print("명언 : ");
        String wiseSaying = sc.nextLine();
        System.out.print("작가 : ");
        String Author = sc.nextLine();

        System.out.print("명령) ");
        cmd = sc.nextLine();


    }
}
