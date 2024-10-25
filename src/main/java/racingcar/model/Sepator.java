package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sepator {
    public List<Car> separateCars(String input) {
        final String DELIMITER = ",";
        List<Car> cars = new ArrayList<>();

        // 문자열 split 시 마지막 빈 값도 배열에 저장하기 위해 limit: -1
        // "pobi," -> ["pobi",""]
        String[] splitInput =  input.split(DELIMITER,-1);
        for (String element : splitInput) {
            cars.add(new Car(element));
        }
        return cars;
    }
}
