package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;

public class RacingCar {

    public void run() {
        String[] carNames = inputCarName();
        int numberOfAttempts = inputNumberOfAttempts();

        Map<String, Integer> cars = createCar(carNames);
    }

    public Map<String, Integer> createCar(String[] carNames) {
        Map<String, Integer> cars = new HashMap<>();
        for (String name : carNames) {
            cars.put(name, 0);
        }
        return cars;
    }

    private String[] inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameInput = Console.readLine();
        return nameInput.split(",");
    }

    private int inputNumberOfAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
