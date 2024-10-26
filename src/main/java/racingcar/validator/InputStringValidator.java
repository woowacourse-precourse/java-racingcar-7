package racingcar.validator;

public class InputStringValidator {
    public static void carNameIsEmpty(String userInputCarNameString) {
        if(userInputCarNameString.isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
    }
}
