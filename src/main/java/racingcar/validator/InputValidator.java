package racingcar.validator;

import racingcar.model.ErrorMessage;

import static racingcar.model.ErrorMessage.*;

public class InputValidator {

    private final static int NAME_LENGTH = 5;

    // 문자열 공백 검증
    public static void validateNotEmpty(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.STRING_IS_EMPTY_MESSAGE);
        }
    }

    // 문자열에 문자가 아닌 값에 대한 검증
    public static void validateCharacter(String input) {
        if (!input.matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException(ErrorMessage.NON_ALPHA_MESSAGE);
        }
    }


    // 차량 이름 길이가 5를 넘는지 검증
    public static void validateNameLength(String input){
        if(input.length() > NAME_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_MESSAGE);
        }
    }


    // 시도 횟수가 1보다 작거나 숫자가 아닌지 검증
    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_NUMBER_MESSAGE);
        }
    }
}
