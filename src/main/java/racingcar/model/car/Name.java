package racingcar.model.car;

import racingcar.error.ErrorMessage;

public class Name {

    String name;

    public Name(String name) {
        if (!validateNameLength(name)) {
            throw new IllegalArgumentException(ErrorMessage.CARNAME_GREATER_THAN_EQUAL_FIVE.getMessage());
        } else if (!validateNameString(name)) {
            throw new IllegalArgumentException(ErrorMessage.CARNAME_NOT_STRING.getMessage());
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    private boolean validateNameLength(String name) {
        if (name.length() >= 5) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateNameString(String name) {
        //숫자가 포함된경우
        if (name.chars().allMatch(Character::isDigit)) {
            return false;
        } else {
            return true;
        }
    }


}
