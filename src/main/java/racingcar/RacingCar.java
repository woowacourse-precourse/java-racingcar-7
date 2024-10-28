package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.LinkedHashMap;
import java.util.Map;

public class RacingCar {

    Map<String, Integer> cars = new LinkedHashMap<>();

    public void run() {
        inputCarName();
        int tryTimes = inputTryTimes();
    }

    private void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        for (String carName : carNames) {
            cars.put(carName, 0);
        }
    }

    private int inputTryTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryTimes = Integer.parseInt(Console.readLine());
        return tryTimes;
    }
}
