package racingcar;

public class Validator {

    public boolean checkIfNameInputIsLegal(String[] names) {

        if(hasNoName(names)){
            throw new IllegalArgumentException();
        }

        for (String name : names) {

            if (isIllegalName(name)) {
                throw new IllegalArgumentException();
            }

        }

        return true;
    }

    public boolean checkStageSizeIsLegal(String input) {
        if (isPositiveNumber(input)) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    private static boolean hasNoName(String[] names) {
        return names.length == 0;
    }

    private static boolean isNameTooLong(String name) {
        return name.length() > 5;
    }

    private static boolean isPositiveNumber(String input) {

        for(int i = 0; i < input.length(); i++){

            char letter = input.charAt(i);
            if(Character.isDigit(letter)){
                continue;
            }

            throw new IllegalArgumentException();
        }

        return true;
    }

    private static boolean isIllegalName(String name) {
        return isNameTooLong(name) || name.isEmpty();
    }
}
