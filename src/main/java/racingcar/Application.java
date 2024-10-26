package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//자동차 이름 및 위치 관리
class Car {
    private final String name;
    private int placement;

    public Car(String name) {
       CheckCarName(name);
        this.name = name;
        this.placement = 0;
    }

    //이름 확인하기 -> 예외상황 생각해둬야함
    private void CheckCarName(String name) {
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
        try{
            List<String> carNames = inputCarNames();

            System.out.println("최종 우승자 : ");
        } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
    }

    private static List<String> inputCarNames() {
       System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
       String carNamesInput = Console.readLine();
       List<String> carNames = List.of(carNamesInput.split(","));
       CheckCarName(carNames);
       return carNames;
    }

    private static void CheckCarName(List<String> carNames) {
        if (carNames.isEmpty()) { throw new IllegalArgumentException(); }
    }

}
