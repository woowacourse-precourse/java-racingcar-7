package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Cars extends HashMap<String, Integer> {
    Cars(Set<String> carNames) {
        addCars(carNames);
    }

    public void addCars(Set<String> carsName) {
        for (String carName : carsName) {
            this.put(carName, 0);
        }
    }

}