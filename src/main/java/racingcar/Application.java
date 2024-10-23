package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {
    static Map<String, Integer> car = new HashMap<>();

    public static void printInputMessageCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static void moveOrStop(String carName, int randomNumber) {
        if (randomNumber >= 4) {
            car.put(carName, car.get(carName) + 1);
        }
    }

    public static void main(String[] args) {
        printInputMessageCarName();
        car.put("박", 0);
        car.put("재", 0);
        car.put("은", 0);
        int randomNumber = makeRandomNumber();
        System.out.println(randomNumber);
        moveOrStop("박", randomNumber);
        for (String key : car.keySet()) {
            System.out.println(key + ":" + car.get(key));
        }
    }
}
