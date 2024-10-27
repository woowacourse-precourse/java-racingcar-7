package racingcar.validator;

public class Validator {
    private static String inputString;
    private static int inputSize;
    public String userName;

    public void userNameValidate(String userName) {
        this.userName = userName;
        isExceedMaxLen();
    }

    public void isCommaInFrontorBack() {
        if ((inputString.charAt(0) == ',') || (inputString.charAt(inputSize - 1) == ',')) {
            throw new IllegalArgumentException();
        }
    }

    public void isExceedMaxLen() {
        if (userName.length() > 5) {
            throw new IllegalArgumentException();
        }

    }

    public void isEmptyInput() {
        if (inputString.equals("")) {
            throw new IllegalArgumentException();
        }
    }

    public Validator(String inputString) {
        this.inputString = inputString;
        this.inputSize = inputString.length();
    }
}
