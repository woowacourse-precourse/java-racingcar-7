package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class RacingCarController {

    public void run() {
        Map<String, Integer> carInfo = getCarInfo();
        int attemptCount = getAttemptCount();
        System.out.println(carInfo.toString());
        System.out.println(attemptCount);
    }

    public Map<String, Integer> getCarInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] cars = carNames.split(",");
        Map<String, Integer> carInfo = new HashMap<>();
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            } else {
                carInfo.put(car, 0);
            }
        }
        return carInfo;
    }

    public int getAttemptCount() {
        int attemptCount = 0;
        try {
            attemptCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return attemptCount;
    }
}
