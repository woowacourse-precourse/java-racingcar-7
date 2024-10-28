package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCar {

    Map<String, Integer> cars = new LinkedHashMap<>();

    public void run() {
        inputCarName();
    }

    private void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            cars.put(carName, 0);
        }
    }
}
