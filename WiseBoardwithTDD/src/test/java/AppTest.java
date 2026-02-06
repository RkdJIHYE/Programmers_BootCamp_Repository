import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {

    @Test
    @DisplayName("== 명언 앱 == '명령'")
    void t1(){
        //input 으로 종료 넣어주고
        Scanner sc = TestUtil.getScanner("종료");

        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();
        new App(sc).run();


        String out = outputStream.toString();

        assertThat(out).contains("== 명언 앱==");


    }


}
