import java.util.HashMap;
import java.util.Map;

public class Rq {

    private String action;
    //          key     value
    private Map<String,String> paramMap;


    //cmd = 행위?id=파라미터
    public Rq(String cmd){

        paramMap = new HashMap<>();
        String[] cmdBits = cmd.split("\\?");
        action = cmdBits[0];
        //System.out.print(cmdBits);

        //삼항연산자 이용
        String params = cmdBits.length>1 ?cmdBits[1]:"";

        String[] paramBits = params.split("&");

        for (int i =0;i<paramBits.length;i++){
            String[] paramArg = paramBits[i].split("=");
            String key = paramArg[0];
            String value = paramArg.length >1?paramArg[1]:"";

            paramMap.put(key,value);
        }

    }

    //고객이 어떤 행위를 하고 싶은지 반환하는 메소드
    public String getAction() {
        return action;
    }

    //고객이 수정하고자하는 대상
    public String getParam(String key){
        return paramMap.get(key);
    }

    //문자열을 -> 숫자로 변환해서 주는 것
    public int getParamInt(String key){
        return Integer.parseInt(paramMap.get(key));
    }






}
