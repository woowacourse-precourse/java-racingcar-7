package racingcar.model;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MAX_CAR_NAME_SIZE = 5;

    private final String name;
    private final int position;

    private Car(String name) {
        validateCar(name);

        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public static Car from(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCar(String name) {
        if (name.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
