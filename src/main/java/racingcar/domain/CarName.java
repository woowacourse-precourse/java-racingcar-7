package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class CarName {

    private static final int MIN_CAR_COUNT = 2;
    private static final int MAX_CAR_COUNT = 10;

    private final List<String> carNames;

    public CarName(List<String> carNames) {
        this.carNames = carNames;
        validate();
    }

    private void validate() {
        isNameLengthValid();     // 이름 길이 검증
        isNameNotEmpty();        // 이름이 비어있는지 검증
        isNameDuplicate();       // 이름 중복 검증
        isValidCarCount();       // 자동차 개수 검증
    }

    private void isNameLengthValid() {
        for (String carName : carNames) {
            checkCarNameLength(carName);
        }
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름의 길이가 5이하만 가능합니다.");
        }
    }

    private void isNameNotEmpty() {
        for (String carName : carNames) {
            checkCarNameEmpty(carName);
        }
    }

    private void checkCarNameEmpty(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
    }

    private void isNameDuplicate() {
        for (String carName : carNames) {
            checkCarNameDuplicate(carName);
        }
    }

    private void checkCarNameDuplicate(String carName) {
        if (Collections.frequency(carNames, carName) > 1) {
            throw new IllegalArgumentException("이름이 중복되었습니다.");
        }
    }

    private void isValidCarCount() {
        if (carNames.size() > MAX_CAR_COUNT || carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차의 갯수가 적정 수가 아닙니다.");
        }
    }

    public List<String> getCarNameList() {
        return carNames;
    }

}
