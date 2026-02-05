import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


//Rq rq = new Rq("목록?keword=자바&keywordType=title&page=2");
//
//rq.getActionName(); // 목록
//rq.getParam("keword", ""); // "자바"
//rq.getParam("keywordType", ""); // "title"
//rq.getParamAsInt("page", 1); // 2
//
//rq.getParam("wrongParam", ""); // ""
//rq.getParamAsInt("wrongParam", -1); // -1

//rq 는 -> cmd -> 명령어 action과 parameter를 따로 처리
// -> action / parameter는 key - value 로 map(hash)를 이용하여 저장
// -> 이를 통해 key를 넣으면 value를 도출하도록 했다.
public class RqTest {
    @Test
    @DisplayName("rq.getActionName()")
    void t1() {
        Rq rq = new Rq("삭제?id=1");
        String actionName = rq.aetActionName();
        assertThat(actionName).isEqualTo("삭제");
    }

}
