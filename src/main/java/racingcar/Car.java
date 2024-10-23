package racingcar;

public class Car {
    private final String name;

    // TODO: 예외 메시지 처리
    public Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
