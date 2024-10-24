package racingcar.model.domain;

public class Car {

    private static final int START_POSITION = 0;
    private final String name;
    private final int position;


    private Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        if (name.length() >= 6 || name.isBlank()) {
            throw new IllegalArgumentException("한글자 이상, 다섯글자 이하로 입력하세요.");
        }

        return new Car(name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public Car moveForward() {
        return new Car(this.name, this.position + 1);
    }
}
