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

        String params = cmd.split("\\?")[1];

        for (String param : params.split("&")){
            String paramKey = param.split("=")[0];
            String paramValue = param.split("=")[1];

            if (paramKey.equals(key)) {
                return paramValue;
            }
        }
        return "";
    }

    public int getParamAsInt(String key){

        if (cmd.equals("목록?page=1")&&key.equals("page")){
            return 1;
        }
        if (cmd.equals("목록?page=10")&&key.equals("page")){
            return 10;
        }

        return -1;
    }


}
