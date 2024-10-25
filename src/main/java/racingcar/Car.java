package racingcar;

public class Car {

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    // TODO: 예외 메시지 처리
    public Car(String name, int position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name.trim();
        this.position = position;
    }

    public int go(MoveCondition moveCondition) {
        if (moveCondition.canMove()) {
            return ++this.position;
        }
        return this.position;
    }

    public String getName() {
        return name;
    }
}
