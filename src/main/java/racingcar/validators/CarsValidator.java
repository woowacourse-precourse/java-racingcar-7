package racingcar.validators;

import java.util.List;
import racingcar.common.Languages;
import racingcar.common.Ranges;

public class CarsValidator {
    private final List<String> cars;

    public CarsValidator(List<String> cars) {
        this.cars = cars;
    }

    public void validate() {
        validateCharacters();
        validateLength();
        validateEmpty();
        validateDuplicates();
        validateMaxCarCount();
    }

    private void validateCharacters() {
        if (!cars.stream().allMatch(car -> car.matches(
                "^[" + Languages.ENGLISH.getRegex() + Languages.KOREAN.getRegex() + "]*$"
        ))) {
            throw new IllegalArgumentException("이름에 허용되지 않는 문자가 들어가 있습니다 (한국어+영어만 가능).");
        }
    }

    private void validateLength() {
        if (cars.stream().anyMatch(car -> car.length() > Ranges.MAX_NAME_LENGTH.getValue())) {
            throw new IllegalArgumentException("각 이름의 길이는 " + Ranges.MAX_NAME_LENGTH.getValue() + "자를 넘길 수 없습니다.");
        }
    }

    private void validateEmpty() {
        if (cars.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("빈 이름이 존재합니다.");
        }
    }

    private void validateDuplicates() {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException("중복되는 이름이 존재합니다.");
        }
    }

    private void validateMaxCarCount() {
        if (cars.size() > Ranges.MAX_CARS.getValue()) {
            throw new IllegalArgumentException("차의 대수는 " + Ranges.MAX_CARS.getValue() + "대를 넘길 수 없습니다.");
        }
    }
}
