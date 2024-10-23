package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final static String COMMA = ",";
    private final List<Car> cars;
    public Cars(String carNames) {
        List<String> convertedStringToList = convertStringToList(carNames);
        validateProcess(convertedStringToList);
        this.cars = convertedStringToList.stream().map(Car::new).collect(Collectors.toList());
    }
    private List<String> convertStringToList(String carNames) {
        return List.of(carNames.split(COMMA));
    }
    private void validateProcess(List<String> carNames) {
        validateLengthCarName(carNames);
        validateDuplicationCarName(carNames);
    }

    private void validateLengthCarName(List<String> carNames) {
        for(String carName : carNames) {
            if(carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicationCarName(List<String> carNames) {
        HashMap<String, Integer> carsMap = new HashMap<>();
        for (String carName : carNames) {
            carsMap.put(carName, carsMap.getOrDefault(carName,0) + 1);
        }
        for (int count : carsMap.values()) {
            if (count > 1) {
                throw new IllegalArgumentException();
            }
        }
    }
}
