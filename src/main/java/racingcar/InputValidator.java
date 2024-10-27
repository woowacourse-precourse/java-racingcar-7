package racingcar;

import java.util.LinkedHashMap;

public class InputValidator {
    final String inputText;
    final LinkedHashMap<Car, Integer> splitInputText;

    public InputValidator(String inputText) {
        this.inputText = inputText;
        splitInputText = new InputParser(inputText).splitByComma();
    }

    public void carNameValidator() {
        if (isBlankInput()) {
            throw new IllegalArgumentException("경주할 자동차 이름을 입력하세요.");
        } else if (isCarNameTooLong()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void attemptCountValidator() {
        if (isBlankInput()) {
            throw new IllegalArgumentException("시도 횟수를 입력하세요.");
        }
    }

    private boolean isBlankInput() {
        return inputText.isBlank();
    }

    private boolean isCarNameTooLong() {
        for (Car car : splitInputText.keySet()) {
            if (car.getCarName().length() > 5) {
                return true;
            }
        }
        return false;
    }
}