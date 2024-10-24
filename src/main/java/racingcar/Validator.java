package racingcar;

import java.util.HashMap;

public class Validator {
    private HashMap<String, Boolean> parsedNames;
    private int nameCount;
    private String curName;

    Validator() {
        parsedNames = new HashMap<>();
        nameCount = 0;
        curName = "";
    }

    public void checkValidName(String name) {
        curName = name;
        checkValidFormat();

        nameCount++;
        parsedNames.put(name, true);
        System.out.println(name + ": " + parsedNames.get(name));
    }

    private void checkValidFormat() {
        if (isValidLength() == false ||
                isValidNumOfName() == false ||
                isNotOverlapped() == false ||
                isValidCharacters() == false) {
            Printer.printMessage(Constants.INPUT_ERROR_INVALID);
            throw new IllegalArgumentException();
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
        return false;
    }
}