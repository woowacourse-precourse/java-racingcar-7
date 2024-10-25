package racingcar.car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

    private static final String NAME_COUNT_ERROR_MESSAGE = "이름을 2개 이상 입력해야 합니다.";
    private static final String DUPLICATED_NAME_ERROR_MESSAGE = "중복된 이름을 입력하면 안됩니다.";
    private static final String EMPTY_STRING_NAME_ERROR_MESSAGE = "빈 이름을 입력할 수 없습니다.";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이는 5글자 이하만 가능합니다.";
    private static final String EMPTY_STRING = "";
    private static final int MAX_LENGTH_OF_NAME = 5;

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateNameCount(names);
        validateDuplicatedNames(names);
        validateEmptyStringName(names);
        validateNameLength(names);
        cars = initializeCarList(names);
    }

    public int carCount() {
        return cars.size();
    }

    private void validateNameCount(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException(NAME_COUNT_ERROR_MESSAGE);
        }
    }

    private void validateDuplicatedNames(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR_MESSAGE);
        }
    }

    private void validateEmptyStringName(List<String> names) {
        if (names.contains(EMPTY_STRING)) {
            throw new IllegalArgumentException(EMPTY_STRING_NAME_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(List<String> names) {
        for (String name : names) {
            if (name.length() > MAX_LENGTH_OF_NAME) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private List<Car> initializeCarList(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
