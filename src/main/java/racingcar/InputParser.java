package racingcar;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    private static final String CARNAME_DELIMITER = ",";

    public List<Car> stringToCarList(String input) {
        List<Car> carList = new ArrayList<>();

        for (String carName : input.split(CARNAME_DELIMITER, -1)) {
            carList.add(Car.from(carName.trim()));
        }

        return carList;
    }
}
