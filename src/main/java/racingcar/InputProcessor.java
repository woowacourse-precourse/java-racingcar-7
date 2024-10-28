package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] cars = input.split(",");
        return checkCarNames(cars);
    }

    private static List<String> checkCarNames(String[] cars) {
        List<String> carList = new ArrayList<>();
        for(String car : cars) {
            if (car.isEmpty()) {
                continue;
            }
            if (car.length() > 5) {
                throw new IllegalArgumentException("Invalid String length");
            }
            carList.add(car);
        }
        return carList;
    }

}
