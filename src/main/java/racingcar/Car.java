package racingcar;

public class Car {
    private final String name;
    private final MoveStrategy moveStrategy;
    private int position;

    public Car(String name, MoveStrategy moveStrategy) {
        validateName(name);
        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.");
        }
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
}
