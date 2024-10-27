package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constant.Constant;

public class CarNames {
    private final List<String> carNames;

    public CarNames(List<String> carNames) {
        this.carNames = new ArrayList<>(carNames);
    }

    public static CarNames from(String input) {
        validateInputBlank(input);
        String[] names = splitCarName(input);
        for (String name : names) {
            validateNameBlank(name);
            validateNameTooLong(name);
        }
        validateDuplicatedName(names);
        return new CarNames(Arrays.asList(names));
    }

    private static void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차의 이름을 입력해 주세요.");
        }
    }

    private static void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름을 지정하지 않은 자동차가 있습니다.");
        }
    }

    private static void validateNameTooLong(String name) {
        if (name.length() > Constant.CAR_NAME_LENGTH_CRITERIA) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하로 설정해 주세요.");
        }
    }

    private static void validateDuplicatedName(String[] names) {
        Set<String> cars = new HashSet<>(Arrays.asList(names));
        if (cars.size() != names.length) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
    }

    private static String[] splitCarName(String input) {
        String[] names = input.split(Constant.DELIMITER);
        Arrays.setAll(names, i -> names[i].trim());
        return names;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
