package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private final String DELIMITER = ",";
    private final List<Car> carList;
    Validation validation = new Validation();

    public RacingCarList() {
        this.carList = new ArrayList<>();
    }

    public void add(String carNames) {
        String[] splitNames = carNames.split(DELIMITER);
        for (String splitName : splitNames) {
            validation.validateCarName(splitName);
            carList.add(new Car(splitName));
        }
        System.out.println(carList);
    }

    public void moveCar(String carName, int position) {

    }
}
