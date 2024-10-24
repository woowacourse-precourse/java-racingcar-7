package racingcar;

public class Car {

    private final String name;
    private int position;

    // TODO: 예외 메시지 처리
    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.position = position;
    }

    public int go() {
        return ++this.position;
    }

    public int getPosition() {
        return position;
    }
}
