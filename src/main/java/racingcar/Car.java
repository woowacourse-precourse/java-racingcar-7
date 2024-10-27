package racingcar;

public class Car {

    private final String name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(name, new Position(position));
    }

    public Car(String name, Position position) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("자동차 이름은 null 이거나 빈 칸일 수 없습니다. 입력된 이름: (%s)", name));
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(String.format("자동차 이름은 쉼표(,)를 기준으로 5글자이하로만 가능합니다. 입력된 이름: (%s)", name));
        }
        this.name = name.trim();
        this.position = position;
    }

    public void move(MoveCondition moveCondition) {
        if (moveCondition.canMove()) {
            this.position = position.goForward();
        }
    }

    public boolean isWinnerPosition(int winnerPosition) {
        return position.isWinnerPosition(winnerPosition);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
