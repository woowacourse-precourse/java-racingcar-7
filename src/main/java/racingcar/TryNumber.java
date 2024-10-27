package racingcar;

import view.ErrorMessage;

public class TryNumber {
    private int tryNumber; // 시도 횟수를 int로 변경

    public int getTryNumber() {
        return tryNumber;
    }

    public void setTryNumber(String tryNumber) {
        tryNumberValidation(tryNumber);
        this.tryNumber = Integer.parseInt(tryNumber); // 문자열을 정수로 변환하여 설정
    }

    private void tryNumberValidation(String tryNumber) {
        isNull(tryNumber); // null 또는 빈 문자열 확인
        isDigitString(tryNumber); // 숫자 문자열 확인
        isPositiveNumber(tryNumber); // 0 이상의 숫자 확인
    }

    private void isDigitString(String tryNumber) {
        for (int i = 0; i < tryNumber.length(); i++) {
            isDigitChar(tryNumber.charAt(i)); // 각 문자가 숫자인지 확인
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

    private void isPositiveNumber(String tryNumber) {
        // 숫자를 정수로 변환 후 0 이상인지 확인
        if (Integer.parseInt(tryNumber) < 0) {
            throw new IllegalArgumentException("시도 횟수는 0 이상의 숫자여야 합니다."); // 음수에 대한 예외 처리
        }
    }
}
