package racingcar.domain.Car;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNaming(name);
        this.name = name;

    }

    private void validateNaming(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
    
    public String getName() {
        return name;
    }

}
