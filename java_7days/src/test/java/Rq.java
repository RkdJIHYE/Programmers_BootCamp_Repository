public class Rq {

    private String cmd;

    public Rq(String cmd){
        this.cmd = cmd;
    }

    public String aetActionName(){
        if (cmd.startsWith("삭제")){
            return "삭제";
        }
        if (cmd.startsWith("수정")){
            return "수정";
        }
        return "";
    }

}
