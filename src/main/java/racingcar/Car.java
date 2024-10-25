package racingcar;

public class Car {
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean isName(String givenName) {
        return name.equals(givenName);
    }
}
