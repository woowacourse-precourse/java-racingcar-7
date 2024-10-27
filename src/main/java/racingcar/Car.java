package racingcar;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this(name, new Position(position));
    }

    public Car(String name, Position position) {
        this(new Name(name), position);
    }

    public Car(Name name, Position position) {
        this.name = name;
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
        return name.getValue();
    }

    public Position getPosition() {
        return position;
    }
}
