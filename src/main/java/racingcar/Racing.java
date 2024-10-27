package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.Map;

public class Racing {
    private String cars;
    private Integer attemptsCnt;
    private Map<String, String> racingCars;
    private final String DELIMITERS = ",";

    Racing() {}

    public void input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Console.readLine();
        splitCarsName(cars);

        System.out.println("시도할 횟수는 몇 회인가요?");
        attemptsCnt = Integer.valueOf(Console.readLine());
    }

    private void splitCarsName(String cars) {
        String[] carNames = cars.split(DELIMITERS);
        makeCarsDict(carNames);
    }

    private void makeCarsDict(String[] carNames) {
        racingCars = new HashMap<>();

        for (String name : carNames) {
            racingCars.put(name, "");
        }
    }
}
