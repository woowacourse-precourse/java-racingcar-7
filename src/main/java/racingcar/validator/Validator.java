package racingcar.validator;

public class Validator {

    public void validateInputNotBlank(String carNames) {
        if (carNames.isBlank()) {
            throw new IllegalArgumentException("입력받은 자동차 이름이 없습니다.");
        }
    }


    public void validateCarNameLength(String[] cars) {
        for (String car : cars) {
            if (car.length() >= 6) {
                throw new IllegalArgumentException("입력받은 자동차 이름의 크기가 6이상 입니다."); //
            }
        }
    }

    public void validateNoEmptyCarNames(String carNames) {
        String[] cars = carNames.split(",", -1);
        for (String car : cars) {
            if (car.trim().isEmpty()) {
                throw new IllegalArgumentException("이름이 없는 자동차가 존재 합니다.");
            }
        }
    }
}
