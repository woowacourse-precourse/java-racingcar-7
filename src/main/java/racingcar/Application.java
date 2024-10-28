package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceRoundCount;
        try {
            raceRoundCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        Map<String, Integer> cars = new HashMap<>();

        String[] carsName = carsInput.split(",");

        for (String car : carsName) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
            cars.put(car, 0);
        }

        for (int count = 0; count < raceRoundCount; count++) {
            for (String car : cars.keySet()) {
                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    cars.put(car, cars.get(car) + 1);
                }
            }
        }
    }
}
