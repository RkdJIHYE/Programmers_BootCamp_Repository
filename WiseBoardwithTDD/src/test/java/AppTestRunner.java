import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input) {
        Scanner sc = TestUtil.getScanner(input);

        //모니터로 나오는 대신 배열로 보내기 위함
        ByteArrayOutputStream outputStream = TestUtil.setOutByteArray();
        //테스트를 하기위한 run 메소드
        new App(sc).run();


        return outputStream.toString();
    }
}
