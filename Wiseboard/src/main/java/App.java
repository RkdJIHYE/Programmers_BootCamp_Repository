import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    //메서드에서 공유하기 위해서 객체의 전역변수로 바꿔준다.

    private Scanner sc = new Scanner(System.in);
    private int last_cnt = 0;
    //객체 인스턴스 생성
    //추가 리스트로 생성함
    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int last_idx = -1;


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
            else if (cmd.startsWith("수정")){
                actionModify(cmd);
            }
        }
    }

    private void actionModify(String cmd){

        String idStr = cmd.split("=")[1];
        int id = Integer.parseInt(idStr);

        WiseSaying wiseSaying=findByID(id);
        if (wiseSaying==null){
            System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
            return;
        }

        //사용자 상호작용만 따로 뺀다.
        System.out.print("명언(기존) : %s\n".formatted(wiseSaying.getContent()));
        System.out.print("명언 : ");
        String new_content = sc.nextLine();
        System.out.print("작가(기존) : %s\n".formatted(wiseSaying.getAuthor()));
        System.out.print("작가 : ");
        String new_author = sc.nextLine();

        modify(wiseSaying,new_content,new_author);
    }

    private void modify(WiseSaying wiseSaying,String new_content,String new_author){
       wiseSaying.setContent(new_content);
       wiseSaying.setAuthor(new_author);
    }
    private WiseSaying findByID(int id){
        int ModifyTarget = id;

        int findIdx =findIndexById(id);
        if (findIdx==-1){
            return null;
        }
        else{
            return wiseSayings.get(findIdx);
        }
    }


    private int findIndexById(int id){
        for (int i =0;i<=last_idx;i++){
            WiseSaying findWiseSaying = wiseSayings.get(i);
            if (id == findWiseSaying.getCnt()){
                return i;
                //수정하고자하는 인덱스의 위치를 발견하게 되었다.
            }
        }
        return -1;
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
            return;
        }

    }

    private boolean delete(int id){
        int findIdx = findIndexById(id);
        if (findIdx==-1) return false;
        //추가된 리무브 기능
        wiseSayings.remove(findIdx);
        return true;
    }

    private void actionShow() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayingList = findList();
        //리스트 버전

        //배열 버전
        //WiseSaying[] foundedWiseSayings = findList();

        for (WiseSaying wiseSaying : wiseSayingList){
            System.out.printf("%d / %s / %s \n",wiseSaying.getCnt(),wiseSaying.getAuthor(), wiseSaying.getContent());
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
        //생성자 이용해서 같이 넣기

        WiseSaying wiseSaying = new WiseSaying(last_cnt,content,author);

        wiseSayings.add(wiseSaying);
    }

    private  List<WiseSaying> findList(){
        //리스트 버전
        List<WiseSaying> wiseSayingList = new ArrayList<>();

        //배열 버전
        //WiseSaying[] foundedWiseSayings = new WiseSaying[last_idx + 1];
        int foundedWiseSayingIndex = -1;

        for (int i = last_idx; i >= 0; i--) {
            WiseSaying foundedWiseSaying = wiseSayings.get(i);
            wiseSayingList.add(foundedWiseSaying);
        }

        return wiseSayingList;
    }

}
