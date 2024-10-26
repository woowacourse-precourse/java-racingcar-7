package racingcar;
public class ValidatorForCount implements Validater {
    @Override
    public void checkValidation(String input) {
        checkValidFormat(input);
        System.out.println("count: " + input);
    }

    private void checkValidFormat(String input) {
        if (isValidCharacters(input) == false ||
                isValidNumber(input) == false) {
            Printer.printMessage(Constants.INPUT_ERROR_INVALID);
            throw new IllegalArgumentException();
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