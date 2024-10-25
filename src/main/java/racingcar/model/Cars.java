package racingcar.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cars {
    public static final int MAX_CAR_COUNT = 5;
    public static final int MIN_CAR_COUNT = 2;
    public static final String DELIMITER = ",";

    private static final Map<String, Car> carsCache = new HashMap<>();

    public Cars(String carNames) {
        validateBasicCarNameConditions(carNames);
        validateCarNames(convertListString(carNames));
        generateCars(carNames);

    }

    public Collection<Car> getAllCars() {
        return carsCache.values();
    }

    private void validateBasicCarNameConditions(String carNames) {
        validateNoConsecutiveCommas(carNames);
        validateDelimiterPosition(carNames);
    }

    public static void validateNoConsecutiveCommas(String input) {
        if (input.contains(DELIMITER + DELIMITER)) {
            throw new IllegalArgumentException("연속된 콤마는 허용되지 않습니다.");
        }
    }

    private void validateDelimiterPosition(String carName) {
        if(carName.startsWith(DELIMITER) || carName.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("처음과 마지막에 구분자를 포함시킬 수 없습니다.");
        }
    }

    private List<String> convertListString(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .toList();
    }

    private void validateCarNames(List<String> carNameList) {
        validateUniqueCarNames(carNameList);
        validateMAXCarCount(carNameList);
        validateMinCarCount(carNameList);
    }

    private void validateUniqueCarNames(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private void validateMAXCarCount(List<String> carNamesList) {
        if(carNamesList.size() > MAX_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는" + MAX_CAR_COUNT + "대 이하로만 설정할 수 있습니다.");
        }
    }

    private void validateMinCarCount(List<String> carNamesList) {
        if(carNamesList.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("레이스를 하기위해 최소" + MIN_CAR_COUNT + "대 이상의 자동차가 필요합니다.");
        }
    }

    private void generateCars(String carNames) {
        Arrays.stream(carNames.split(DELIMITER))
                .forEach(carName -> carsCache.put(carName.trim(), new Car(carName.trim())));
    }
}
