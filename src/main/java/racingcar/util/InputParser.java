package racingcar.util;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String SEPARATOR = ",";

    public static List<Car> parseInput(String inputString) {
        List<Car> carList = new ArrayList<>();
        String[] carNames = inputString.split(SEPARATOR);
        for(String carname : carNames) {
            if (carname.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            carList.add(Car.create(carname));
        }
        return carList;
    }
}
