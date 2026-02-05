public class Rq {

    private String cmd;

    public Rq(String cmd){
        this.cmd = cmd;
    }

    public String getActionName(){
//        if (cmd.startsWith("삭제")){
//            return "삭제";
//        }
//        if (cmd.startsWith("수정")){
//            return "수정";
//        }
        return cmd.split("\\?")[0];
    }

    public String getParam(String key) {
//        if (cmd.equals("목록?keyword=자바")){
//            return "자바";
//        }
//        if (cmd.equals("목록?keywordType=title")){
//            return "title";
//        }

        String param = cmd.split("\\?")[1];
        String paramKey = param.split("=")[0];
        //String paramValue = param.split("=")[1];

        if (paramKey.equals("keyword")) {
            return "자바";
        }
        if (paramKey.equals("keywordType")) {
            return "title";
        }
        return "";
    }


}
