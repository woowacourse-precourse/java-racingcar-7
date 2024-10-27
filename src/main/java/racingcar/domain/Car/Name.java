package racingcar.domain.Car;

import racingcar.exceptions.InvalidNameException;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNaming(name);
        this.name = name;

    }

    private void validateNaming(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameException("이름은 1자 이상, 5자 이하로 구성해야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

}
