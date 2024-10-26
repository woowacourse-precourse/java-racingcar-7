package racingcar.validator;

public class TrialNumberValidator {

    public static void validate(String rawTrialNumber) {
        validateNotEmpty(rawTrialNumber);
        validateIsNumber(rawTrialNumber);
        validateIsInteger(rawTrialNumber);

    }

    private static void validateNotEmpty (String rawTrialNumber){
        if( rawTrialNumber.isEmpty() ){
            throw new IllegalArgumentException("입력값이 공백입니다.");
        }
    }

    private static void validateIsNumber (String rawTrialNumber){
        try {
            Float.parseFloat(rawTrialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
        }
    }

    private static void validateIsInteger (String rawTrialNumber){
        try {
            Integer.parseInt(rawTrialNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }


}
