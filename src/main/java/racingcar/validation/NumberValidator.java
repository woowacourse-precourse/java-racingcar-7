package racingcar.validation;

public class NumberValidator {

    private static final String NUMBER_ERROR_MESSAGE = "횟수 입력 오류입니다.";

    public static void validateNumberString(String numberString){
        validateIsEmpty(numberString);
        validateIsNumeric(numberString);

        Integer number = Integer.parseInt(numberString);
        validateIsPositive(number);
        validateBiggerThenTen(number);
    }

    private static void validateIsEmpty(String numberString) {
        if(numberString.isEmpty())
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
    }

    private static void validateIsNumeric(String numberString) {
        if (!numberString.matches("\\d+")) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateIsPositive(Integer number) {
        if(number<=0){
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateBiggerThenTen(Integer number) {
        if(number>10)
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
    }
}
