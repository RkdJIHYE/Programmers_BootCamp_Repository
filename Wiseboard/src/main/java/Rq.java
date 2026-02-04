public class Rq {

    private String action;
    //cmd = 행위?id=파라미터
    Rq(String cmd){
        String[] cmdlists = cmd.split("\\?");
        action = cmdlists[0];
        //System.out.print(cmdlists);



    }

    //고객이 어떤 행위를 하고 싶은지 반환하는 메소드
    public String getAction() {
        return "등록";
    }

    //고객이 수정하고자하는 대상
    public int getTarget(){
        return 1;
    }
}
