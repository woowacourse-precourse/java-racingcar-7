package racingcar.model;

import racingcar.constant.Message;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Sepator {
    public List<Car> separateCars(String input) {
        final String DELIMITER = ",";
        List<Car> cars = new ArrayList<>();

        // 문자열 split 시 마지막 빈 값도 배열에 저장하기 위해 limit: -1
        // "pobi," -> ["pobi",""]
        List<String> splitInput =  Arrays.stream(input.split(DELIMITER,-1)).toList();
        for (String element : splitInput) {
            cars.add(new Car(element));
        }
        Set<String> carsSet = Set.copyOf(splitInput);
        if (carsSet.size() != cars.size()) {
            throw new IllegalArgumentException(Message.CAR_NAME_DUPLICATE_VALIDATION_MESSAGE.getMessage());
        }
        return cars;
    }
}
