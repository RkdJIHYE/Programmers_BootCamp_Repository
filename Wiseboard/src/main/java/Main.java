import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //스캐너를 이용하여, 키보드에 입력을 받는다.
        Scanner sc = new Scanner(System.in);
        //1단계
        System.out.println("==명언 탭==");
        int cnt =0;
        String Author="";
        String wiseSaying = "";
        while (true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            if (cmd.equals("종료")){
                break;
            }
            //2단계 (등록)
            if (cmd.equals("등록")) {
                ++cnt;
                System.out.print("명언 : ");
                wiseSaying = sc.nextLine();
                System.out.print("작가 : ");
                Author = sc.nextLine();
                System.out.println(cnt+"번이 등록되었습니다.");
            }
            else if (cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                System.out.println(cnt+" / "+Author+" / "+wiseSaying);
            }

        }


    }
}
