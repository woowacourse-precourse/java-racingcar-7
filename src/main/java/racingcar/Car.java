package racingcar;

public class Car {

    private final Name name2;
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
        this.name2 = name;
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
        return name2.getValue();
    }

    public Position getPosition() {
        return position;
    }
}
