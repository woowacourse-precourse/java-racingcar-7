package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String DELIMITER_COMMA = ",";
    private final List<Car> carList;

    public Cars(String carNames) {
        carList = new ArrayList<>();
        String[] splitCarNames = carNames.split(DELIMITER_COMMA);
        for (String carName : splitCarNames) {
            carList.add(new Car(carName));
        }
    }
}
