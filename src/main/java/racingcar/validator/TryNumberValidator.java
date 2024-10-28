package racingcar.validator;

public class TryNumberValidator {

    public void TryNumberValidate(String tryNumber) {
        if (checkTryNumberIsNotNumber(tryNumber) ||
                checkTryNumberIsNotInteger(tryNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkTryNumberIsNotNumber(String tryNumber) {
        return isNotNumber(tryNumber);
    }

    public boolean checkTryNumberIsNotInteger(String tryNumber) {
        return isNotInteger(tryNumber);
    }


    //시도 횟수가 숫자가 아니면 true, 숫자면 false
    private boolean isNotNumber(String number) {
        char tryNumber = number.charAt(0);
        if (Character.isDigit(tryNumber)) {
            return false;
        }
        return true;
    }

    //시도 횟수가 1이상의 정수가 아니면 true, 숫자면 false
    private boolean isNotInteger(String number) {
        if (Integer.parseInt(number) >= 1) {
            return false;
        }
        return true;
    }
}
