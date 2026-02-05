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
    @DisplayName("rq.getActionName()-삭제")
    void t1() {
        Rq rq = new Rq("삭제?id=1");
        String actionName = rq.getActionName();
        assertThat(actionName).isEqualTo("삭제");
    }


    @Test
    @DisplayName("rq.getActionName()-수정")
    void t2() {
        Rq rq = new Rq("수정?id=1");
        String actionName = rq.getActionName();
        assertThat(actionName).isEqualTo("수정");
    }

    @Test
    @DisplayName("value = '명령:목록?keyword=자바 rq.getParam(\"keyword\")->자바")
    void t3() {
        Rq rq = new Rq("목록?keyword=자바");
        String rst = rq.getParam("keyword");
        assertThat(rst).isEqualTo("자바");
    }

    @Test
    @DisplayName("value = '명령:목록?keywordType=title rq.getParam(\"keywordType\")->title")
    void t4() {
        Rq rq = new Rq("목록?keywordType=title");
        String rst = rq.getParam("keywordType");
        assertThat(rst).isEqualTo("title");
    }

    @Test
    @DisplayName("value = 목록?keword=자바&keywordType=title일때, rg.getParam(\"keywordType\")->\"title\"")
    void t5() {
        Rq rq = new Rq("목록?keyword=자바&keywordType=title");
        String rst = rq.getParam("keywordType");
        assertThat(rst).isEqualTo("title");
    }

    @Test
    @DisplayName("value = 목록?page=1 일때, rg.getParam(\"page\")->1")
    void t6() {
        Rq rq = new Rq("목록?page=1");
        int rst = rq.getParamAsInt("page");
        assertThat(rst).isEqualTo(1);
    }


    @Test
    @DisplayName("value = 목록?page=10 일때, rg.getParam(\"page\")->10")
    void t7() {
        Rq rq = new Rq("목록?page=10");
        int rst = rq.getParamAsInt("page");
        assertThat(rst).isEqualTo(10);
    }



}
