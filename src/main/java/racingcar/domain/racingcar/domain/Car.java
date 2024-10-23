package racingcar.domain.racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = validateCar(name);
        this.position = 0;
    }

    public static Car of(
            final String name
    ) {
        return new Car(name);
    }

    private String validateCar(final String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름이 적절하지 않습니다.");
        }

        return name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        this.position++;
    }
}
