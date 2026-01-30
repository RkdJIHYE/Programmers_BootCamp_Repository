package org.example;

public class Main {
    public static void main(String[] args) {

        무기 a무기 = new 칼();
        a무기.공격();
        // 출력 : 칼로 공격합니다.

        a무기 = new 활();
        a무기.공격();

        a무기 = new 도끼();
        a무기.공격();
        // 출력 : 활로 공격합니다.

        a무기 = new 몽둥이();
        a무기.공격();


    }

}
abstract class 무기{
    abstract void 공격();
}

class 몽둥이 extends 무기 {
    void 공격(){
        System.out.println("몽둥이로 공격합니다.");

    }
}

class 칼 extends 무기{
    void 공격(){
        System.out.println("칼로 공격합니다.");
    }
}

class 활 extends 무기{
    void 공격(){
        System.out.println("활로 공격합니다.");
    }
}

class 도끼 extends 무기 {
    void 공격(){
        System.out.println("도끼로 공격합니다.");
    }
}