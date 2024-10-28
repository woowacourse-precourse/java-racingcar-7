package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars = new ArrayList<>();
    private int attempts;

    public void start() {
        inputCarNames();
    }

    // 자동차 이름 입력
    private void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }
}
