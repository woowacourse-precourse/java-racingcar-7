package validator;

import constant.ErrorCode;

public class AttemptValidator {
    private AttemptValidator() {}

    public static void isPositiveDigit(String attempt) {
        int number;
        try {
            number = Integer.parseInt(attempt);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_ATTEMPT_TYPE.getMessage());
        }
        
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorCode.ATTEMPT_SHOULD_POSITIVE.getMessage());
        }
    }
}
