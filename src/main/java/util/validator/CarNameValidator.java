package util.validator;

import util.splitter.CarNameSplitter;

import java.util.List;

public class CarNameValidator {
    private final CarNameSplitter carNameSplitter;
    public CarNameValidator(CarNameSplitter carNameSplitter) {
        this.carNameSplitter = carNameSplitter;
    }

    public enum ErrorMessage {
        INVALID_SINGLE_CAR("둘 이상의 자동차를 입력해주세요."),
        INVALID_NAME_LENGTH("자동차 이름은 5자를 초과할 수 없습니다."),
        EMPTY_OR_NULL_NAME("자동차 이름에 공백이나 null 값이 포함될 수 없습니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void carNameValidate(List<String> carNames) {
        validateSingleCar(carNames);
        validateNameLength(carNames);
    }

    public void validateSingleCar(List<String> carNames) {
        if (carNames.size() == 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SINGLE_CAR.getMessage());
        }
    }

    public void validateNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
            }
        }
    }
}