package racingcar;

import view.ErrorMessage;

public class TryNumber {
    private String tryNumber;

    public String getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(String tryNumber) {
        tryNumberValidation(tryNumber);
        this.tryNumber = tryNumber;
    }

    private void tryNumberValidation(String tryNumber) {
        isDigitString(tryNumber);
        isNull(tryNumber);
    }

    private void isDigitString(String tryNumber) {
        for (int i = 0; i < tryNumber.length(); i++) {
            isDigitChar(tryNumber.charAt(i));
        }
    }

    private void isDigitChar(char tryNum) {
        if (!Character.isDigit(tryNum)) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NOT_DIGIT_ERROR.print());
        }
    }

    private void isNull(String tryNumber) {
        if (tryNumber == null || tryNumber.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NULL_ERROR.print());
        }
    }
}
