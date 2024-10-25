package racingcar.utils;

import java.util.List;
import racingcar.domain.Car;

public class Utils {

    public String[] convertToCarNameArray(String carNames) {
        return carNames.split(",");
    }

    public void saveCarNamesToList(String[] carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName, ""));
        }
    }
}
