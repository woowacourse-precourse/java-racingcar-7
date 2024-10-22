package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");

        Map<String, Integer> cars = new HashMap<>();
        for (String carName : carNames) {
            cars.put(carName, 0);
        }
    }

    public static void moveCars(Map<String, Integer> cars) {
        for (String carName : cars.keySet()) {
            if (isMoveSuccess()) {
                cars.put(carName, cars.get(carName) + 1);
            }
        }
    }

    public static boolean isMoveSuccess() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
