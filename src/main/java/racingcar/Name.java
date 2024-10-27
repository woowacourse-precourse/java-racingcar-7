package racingcar;

public class Name {

    private final String name;

    public Name(String name) {
        validateNaming(name);
        this.name = name;

    }

    public String getName() {
        return name;
    }

    private void validateNaming(String carName) {
        if(carName.isEmpty() || carName.length() >5) {
            throw new IllegalArgumentException();
        }
    }
}
