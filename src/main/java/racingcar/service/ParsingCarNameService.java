package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class ParsingCarNameService {
    private static final String DELIMITER = ",\\s*";

    public static List<Car> parseCarNames(String inputCarName) {
        String[] inputStrings = inputCarName.split(DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String inputString : inputStrings) {
            cars.add(new Car(inputString));
        }
        return cars;
    }
}
