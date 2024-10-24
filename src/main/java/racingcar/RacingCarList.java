package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private final String DELIMITER = ",";
    private final List<Car> carList;

    public RacingCarList() {
        this.carList = new ArrayList<>();
    }

    public void add(String carNames) {
        String[] splitNames = carNames.split(DELIMITER);
        for (String splitName : splitNames) {
            Validation.validateCarName(splitName);
            carList.add(new Car(splitName));
        }
    }
}