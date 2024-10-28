package racingcar.validator;

public class CarNameValidator {

    public void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다 : " + carName);
        }
    }

    public void validateCarNameIsEmpty(String inputCarsName) {
        if (inputCarsName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
    }
}
