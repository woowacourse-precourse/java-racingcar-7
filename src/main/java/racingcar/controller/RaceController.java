package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final List<Car> cars = new ArrayList<>();

    public void startRace() {
        getCarNames();
    }

    private void getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }
}