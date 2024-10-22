package racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static List<String> carList = new ArrayList<>();

    public Cars(String[] carNames) {
        addCarName(carNames);
    }

    private void addCarName(String[] carNames) {
        for (String carName : carNames) {
            carList.add(carName);
        }
    }
}
