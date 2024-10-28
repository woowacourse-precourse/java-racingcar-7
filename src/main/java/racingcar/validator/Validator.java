package racingcar.validator;

import racingcar.view.InputView;

public class Validator {
    private static String inputString;
    private static int inputSize;
    private String userName;

    public void userNameValidate(String userName) {
        this.userName = userName;
        isEmptyName();
        isExceedMaxNameSize();
    }

    public void userInputValidate() {
        isEmptyInput();
        isExceedMaxInputSize();
        isCommaInFrontorBack();
    }

    public void isCommaInFrontorBack() {
        if ((inputString.charAt(0) == ',') || (inputString.charAt(inputSize - 1) == ',')) {
            throw new IllegalArgumentException();
        }
    }

    public void isExceedMaxNameSize() {
        if (userName.length() > 5) {
            throw new IllegalArgumentException();
        }

    }

    public void isEmptyInput() {
        if (inputString.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public void isEmptyName() {
        if (userName.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public static void isValidateNumber() {
        if (InputView.tryNumber <= 0 || InputView.tryNumber > 1000) {
            throw new IllegalArgumentException();
        }
    }

    public void isExceedMaxInputSize() {
        if (inputString.length() > 5099) {
            throw new IllegalArgumentException();
        }
    }

    public Validator(String inputString) {
        this.inputString = inputString;
        this.inputSize = inputString.length();
    }
}
