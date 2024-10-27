package racingcar;

public class ValidatorForCount {
    public void checkValidation(String input) {
        checkValidFormat(input);
    }

    private void checkValidFormat(String input) {
        if (isValidCharacters(input) == false ||
                isValidNumber(input) == false) {
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_COUNT);
        }
    }

    private boolean isValidCharacters(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c) == false) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidNumber(String input) {
        int num = Integer.parseInt(input);
        if (num == 0 || 10 < num) {
            return false;
        }
        return true;
    }
}