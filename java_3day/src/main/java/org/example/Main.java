package org.example;

public class Main {
    public static void main(String[] args) {

        사람 a사람 = new 사람();

    }
}

class 사람 {
    private int 나이;
    private String 이름;
    private String 거주지;

    public void 자기소개() {
        System.out.println("안녕하세요, 제 이름은 " + 이름 + "이고, 나이는 " + 나이 + "살입니다.");
    }

    // 단축키 alt + insert
    // 게터/세터 자동 생성 가능
    public int get나이() {
        return 나이;
    }

    public void set나이(int 나이) {
        this.나이 = 나이;
    }

    public String get이름() {
        return 이름;
    }

    public void set이름(String 이름) {
        this.이름 = 이름;
    }

    public String get거주지() {
        return 거주지;
    }

    public void set거주지(String 거주지) {
        this.거주지 = 거주지;
    }
}