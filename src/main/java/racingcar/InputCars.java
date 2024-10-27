package racingcar;

import java.util.*;

public class InputCars {
    public Set<String> ReceiveCars() {
        List<String> tempCars;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = System.console().readLine();
        tempCars = Arrays.stream(input.split(",")).toList();
        Set<String> cars = new HashSet<>(tempCars);
        for (var car : cars) {
            if (car.length() > 5)
                throw new IllegalArgumentException();
        }
        return cars;
    }
}
