package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

//자동차 이름 및 위치 관리
class Car {
    private final String name;
    private int placement;

    public Car(String name) {
       CheckName(name);
        this.name = name;
        this.placement = 0;
    }

    //이름 확인하기 -> 예외상황 생각해둬야함
    private void CheckName(String name) {
        if (name.length() > 5) { throw new IllegalArgumentException();}
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) { this.placement++; }
    }

    public String getName() { return name; }
    public int getPlacement() { return placement; }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(placement);
    }
}

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String Car_Name = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");

        System.out.println("실행 결과");
        System.out.println("최종 우승자 : ");
    }
}
