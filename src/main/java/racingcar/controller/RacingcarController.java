package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class RacingcarController {
    public void playGame() {
        List<Car> cars = getCarsFromUserInput();
    }

    private List<Car> getCarsFromUserInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            cars.add(new Car(name));
        }
        return cars;
    }
}
