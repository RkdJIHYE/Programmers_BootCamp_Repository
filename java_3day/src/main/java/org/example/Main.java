package org.example;

public class Main {
    public static void main(String[] args) {

        청둥오리 a청둥오리 = new 청둥오리();
        a청둥오리.날다();
        // 출력 : 오리가 날개로 날아갑니다.
        a청둥오리.수영();
        // 출력 : 오리가 오리발로 헤엄칩니다.

        흰오리 a흰오리 = new 흰오리();
        a흰오리.날다();
        // 출력 : 오리가 날개로 날아갑니다.
        a흰오리.수영();
        // 출력 : 오리가 오리발로 헤엄칩니다.

        고무오리 a고무오리 = new 고무오리();
        a고무오리.날다();
        // 출력 : 저는 날 수 없어요. ㅜㅠ
        a고무오리.수영();
        // 출력 : 오리가 둥둥 떠다닙니다.

        고무2오리 a고무2오리 = new 고무2오리();
        a고무2오리.날다();
        // 출력 : 저는 날 수 없어요. ㅜㅠ
        a고무오리.수영();
        // 출력 : 오리가 둥둥 떠다닙니다.

        로봇오리 a로봇오리 = new 로봇오리();
        a로봇오리.날다();
        // 출력 : 저는 못 날아요 ㅠㅠ
        a로봇오리.수영();
        // 출력 : 오리가 오리발로 헤엄칩니다.
    }
}

class 오리 {
    void 날다() {
        System.out.println("오리가 날개로 날아갑니다.");
    }

    void 수영() {
        System.out.println("오리가 오리발로 헤엄칩니다~~.");
    }
}

class 흰오리 extends 오리 {}

class 청둥오리 extends 오리 {}

class 고무오리 extends 오리 {
    void 날다() {
        System.out.println("저는 못 날아요 ㅠㅠ");
    }

    void 수영() {
        System.out.println("오리가 둥둥 떠다닙니다.");
    }
}

class 고무2오리 extends 고무오리 {}

class 로봇오리{
    오리 오리a = new 오리();
    고무오리 고무a = new 고무오리();

    void 날다(){
        고무a.날다();
    }
    
    void 수영(){
        오리a.수영();
    }

}