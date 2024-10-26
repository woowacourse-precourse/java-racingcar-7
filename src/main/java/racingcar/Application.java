package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    static void validateCarNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (uniqueCarNames.contains(carName)) {
                throw new IllegalArgumentException();
            } else {
                uniqueCarNames.add(carName);
            }
        }
    }

}
