package racingcar;

public class Car {
    private final Rule rule;
    private final Position position;
    private final String name;
//    private int position;

    public Car(String name) {
        this.name = name;
        this.rule = new Rule();
        this.position = new Position(0);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getPositionAsString() {
        return position.toString();
    }

    public void move(int number) {
        if (rule.canMove(number)) {
            position.moveForward();
        }
    }
}
