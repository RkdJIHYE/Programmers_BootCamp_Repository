package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;
import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestUtilTest {


    @Test
    @DisplayName("test.TestUtil.genScanner()")
    void t1 (){
        Scanner sc = TestUtil.getScanner("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        String cmd = sc.nextLine();
        String content = sc.nextLine();
        String author = sc.nextLine();


        assertThat(cmd).isEqualTo("등록");
        assertThat(content).isEqualTo("현재를 사랑하라.");
        assertThat(author).isEqualTo("작자미상");
    }

    @Test
    @DisplayName("test.TestUtil.setOutByteArray()")
    void t2() throws IOException{
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutByteArray();

        System.out.println("안녕하세요");

        String rst = byteArrayOutputStream.toString();

        TestUtil.ClearSetOut(byteArrayOutputStream);

        System.out.println("출력결과 : "+rst);

        //검증하고 싶은 rst 에 안녕하세요가 포함되어 있는지를 확인
        //isEqualTo 대신에 보통 contains 를 사용한다.

        assertThat(rst).contains("안녕하세요");

       }



//    @Test
//    @DisplayName("등록")
//    void t3() {
//        final String out = test.TestUtil.run("""
//                등록
//                현재를 사랑하라.
//                작자미상
//                """);
//
//        assertThat(out)
//                .contains("명언 :")
//                .contains("작가 :")
//                .contains("1번 명언이 등록되었습니다.");
//    }


}
