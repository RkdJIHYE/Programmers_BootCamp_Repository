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
            else if (cmd.startsWith("삭제")){
                actionDelete(cmd);
            }
        }
    }

    private void actionDelete(String cmd) {

        //String num = cmd.substring(6,cmd.length());

        String idStr = cmd.split("=")[1];
        int id = Integer.parseInt(idStr);

        Boolean answer =delete(id);

        if (answer == true){
            System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
        }
        else{
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
        }

    }

    private boolean delete(int id){
        int delTarget = id;
        int findIdx = -1;
        for (int i =0;i<=last_idx;i++){
            WiseSaying findWiseSaying = wiseSayings[i];
            if (delTarget == findWiseSaying.cnt){
                findIdx = i;
                //지우고자하는 인덱스의 위치를 발견하게 되었다.
            }
        }
        if (findIdx==-1) return false;

        for (int j =findIdx;j<last_idx;j++){
            wiseSayings[j]=wiseSayings[j+1];
        }

        last_idx--;
        return true;
    }

    private void actionShow() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        //List<WiseSaying> wiseSayingList = findList();
        //리스트 버전


        //배열 버전
        WiseSaying[] foundedWiseSayings = findList();

        for (WiseSaying wiseSaying : foundedWiseSayings){
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

    private  WiseSaying[] findList(){
        //리스트 버전
        //List<WiseSaying> wiseSayingList = new ArrayList<>();


        //배열 버전
        WiseSaying[] foundedWiseSayings = new WiseSaying[last_idx + 1];
        int foundedWiseSayingIndex = -1;

        for (int i = last_idx; i >= 0; i--) {
            WiseSaying foundedWiseSaying = wiseSayings[i];
            foundedWiseSayings[++foundedWiseSayingIndex] = foundedWiseSaying;
        }

        return foundedWiseSayings;
    }

}
