package racingcar.error;

public class ErrorMessage {
    private ErrorMessage() {
    }

    private static final String NAME_WITH_BLANK_ERROR_MESSAGE = "입력에 공백이 있으면 안됩니다.";
    private static final String NAME_LENGTH_OVER_FIVE_ERROR_MESSAGE = "이름은 5자 이하만 가능합니다.";
    private static final String TRIAL_TIME_IS_NOT_NUMBER_MESSAGE = "입력할 시도 횟수는 숫자만 가능합니다.";
    private static final String TRIAL_TIME_IS_NEGATIVE_NUMBER_MESSAGE = "입력할 시도 횟수는 0 이상의 숫자만 가능합니다.";

    public static void printNameWithBlankError() {
        System.out.println(NAME_WITH_BLANK_ERROR_MESSAGE);
    }

    public static void printNameLengthOverFiveError() {
        System.out.println(NAME_LENGTH_OVER_FIVE_ERROR_MESSAGE);
    }

    public static void printTrialTimeIsNotNumberError() {
        System.out.println(TRIAL_TIME_IS_NOT_NUMBER_MESSAGE);
    }

    public static void printTrialTimeIsNegaviveNumberError() {
        System.out.println(TRIAL_TIME_IS_NEGATIVE_NUMBER_MESSAGE);
    }
}
