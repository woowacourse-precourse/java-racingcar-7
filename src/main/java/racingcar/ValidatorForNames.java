package racingcar;

import java.util.HashMap;

public class ValidatorForNames {
    private HashMap<String, Boolean> parsedNames;
    private int nameCount;
    private String curName;

    ValidatorForNames() {
        parsedNames = new HashMap<>();
        nameCount = 0;
        curName = "";
    }

    public void checkValidation(String input) {
        curName = input;
        checkValidFormat();

        Data.setCarCount(++nameCount);
        parsedNames.put(input, true);
    }

    private void checkValidFormat() {
        if (isValidLength() == false ||
                isValidNumOfName() == false ||
                isNotOverlapped() == false ||
                isValidCharacters() == false) {
            ErrorHandler.printAndThrow(Constants.INPUT_ERROR_NAMES);
        }
    }

    private boolean isValidLength() {
        if (curName.length() == 0 || 5 < curName.length()) {
            return false;
        }
        return true;
    }

    private boolean isValidNumOfName() {
        if (nameCount == 10) {
            return false;
        }
        return true;
    }

    private boolean isNotOverlapped() {
        if (parsedNames.containsKey(curName) == true) {
            return false;
        }
        return true;
    }

    private boolean isValidCharacters() {
        for (char c : curName.toCharArray()) {
            if (Character.isLowerCase(c) == false) {
                return false;
            }
        }
        return true;
    }
}
