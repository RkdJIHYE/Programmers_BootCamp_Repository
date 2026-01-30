import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        //스캐너를 이용하여, 키보드에 입력을 받는다.
        Scanner sc = new Scanner(System.in);
        //1단계
        System.out.println("==명언 탭==");
        int last_cnt = 0;
        //객체 인스턴스 생성
        WiseSaying[] wiseSayings = new WiseSaying[10];
        int last_idx = 0;


        while (true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            if (cmd.equals("종료")){
                break;
            }
            //2단계 (등록)
            if (cmd.equals("등록")) {
                ++last_cnt;
                System.out.print("명언 : ");
                String content = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                WiseSaying wiseSaying = new WiseSaying();

                wiseSaying.cnt = last_cnt;
                wiseSaying.content = content;
                wiseSaying.Author = author;

                wiseSayings[last_idx]=wiseSaying;
                last_idx++;

                System.out.println(last_cnt+"번이 등록되었습니다.");
            }
            else if (cmd.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for(int k=0;k<last_idx;k++){
                   System.out.println(wiseSayings[k].cnt+" / "+wiseSayings[k].Author+" / "+wiseSayings[k].content);
                }
            }

        }


    }
}
