package racingcar;

public class Car {
    private final String name;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // TODO : validate는 따로 객체로 만들어도 괜찮을 것 같다.
    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
