package racingcar.domain;

public class Car {

    private final CarName name;
    private final Condition condition;
    private final Position position;

    public Car(String name, Condition condition) {
        this.name = new CarName(name);
        this.condition = condition;
        this.position = new Position();
    }

    public void forward() {
        if (condition.canMoveForward()) {
            this.position.increasing();
        }
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return this.name.value();
    }

}
