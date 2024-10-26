package racingcar.domain;

import racingcar.utils.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cars {
    static Map<String, Integer> cars = new LinkedHashMap<>();

    public static Map<String, Integer> registerCars() {
        OutputView.promptCarName();
        cars = InputView.inputCarName(); // carName 얻기
        return cars;
    }

    public static void carsPostion(Map<String, Integer> cars) {
        for (Map.Entry<String, Integer> car : cars.entrySet()) {
            OutputView.printCarName(car.getKey());
            for (int i = 0; i < car.getValue(); i++) {
                OutputView.printMoveCar();
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void moveCar(Map<String, Integer> cars) {
        for (String name : cars.keySet()) {
            if (RandomGenerator.randomNumber() >= 4) {
                cars.put(name, cars.get(name) + 1);
            }
        }
    }
}
