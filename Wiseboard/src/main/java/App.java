import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //메서드에서 공유하기 위해서 객체의 전역변수로 바꿔준다.

    Scanner sc = new Scanner(System.in);
    int last_cnt = 0;
    //객체 인스턴스 생성
    WiseSaying[] wiseSayings = new WiseSaying[10];
    int last_idx = -1;


    public void run(){
        //스캐너를 이용하여, 키보드에 입력을 받는다.
        //1단계
        System.out.println("== 명언 탭 ==");

        while (true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();
            if (cmd.equals("종료")){
                break;
            }
            //2단계 (등록)
            else if (cmd.equals("등록")) {
                actionWrite();
            }
            else if (cmd.equals("목록")) {
               actionShow();
            }
        }
    }

    private void actionShow() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayingList = findList();

        for (WiseSaying wiseSaying : wiseSayingList){
            System.out.printf("%d / %s / %s \n",wiseSaying.cnt,wiseSaying.Author, wiseSaying.content);
        }
    }

    private void actionWrite() {
        ++last_cnt;
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();
        write(content,author);
        System.out.println(last_cnt+"번이 등록되었습니다.");

    }

    private void write(String content, String author){

        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.cnt = last_cnt;
        wiseSaying.content = content;
        wiseSaying.Author = author;

        wiseSayings[++last_idx]=wiseSaying;
    }

    private List<WiseSaying> findList(){
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        for (int k = last_idx; k >= 0; k--) {
            WiseSaying foundWiseSaying = wiseSayings[k];
            wiseSayingList.add(foundWiseSaying);

        }

        return wiseSayingList;
    }
}
