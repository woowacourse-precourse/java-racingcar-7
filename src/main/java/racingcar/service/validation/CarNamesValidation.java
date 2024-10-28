package racingcar.service.validation;

import racingcar.exception.ErrorMessage;

public class CarNamesValidation {

    public static void validateAllInput(String input){
        validateEmpty(input);
        validateNull(input);
        validateDelimiter(input);
        validateBetweenDelimiter(input);
    }

    public static void validateEmpty(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NO_CAR_NAME.toString());
        }
    }

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NO_CAR_NAME.toString());
        }
    }

    public static void validateDelimiter(String input) {
        // 쉼표(,)로 나누었을 때, 쉼표 이외의 문자가 포함되어 있으면 예외 처리
        if (!input.replaceAll(" ","").matches("[a-zA-Z,]+")) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_DELIMITER_ONLY_COMMA.toString());
        }
    }

    public static void validateBetweenDelimiter(String input) {
        String[] cars = input.split(",",-1); // -1을 limit으로 넣어주어 문자열의 마지막이 구분자인 경우도 검출
        for (String car: cars){
            throwIfEmpty(car.trim().isEmpty());
        }
    }

    private static void throwIfEmpty(boolean state){
        if (state){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NO_EMPTY_BETWEEN_DELIMITER.toString());
        }
    }

    public static void validateCarName(String carName){
        validateOver(carName);
        validateEng(carName);
    }

    public static void validateOver(String carName) {
        if (carName.length()>5){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_NAME_OVER_FIVE.toString());
        }
    }

    public static void validateEng(String carName) {
        if (!carName.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_ONLY_ENG.toString());
        }
    }
}
