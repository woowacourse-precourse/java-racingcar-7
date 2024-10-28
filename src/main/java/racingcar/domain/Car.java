package racingcar.domain;


public class Car {
    public static final String CAR_POSITION_SIGN = "-";
    public static final int START_POSITION = 0;
    private final CarName name;
    private final Position position;

    public Car(CarName name) {
        this.name = name;
        this.position = new Position(START_POSITION);
    }

    public boolean isSamePosition(int position) {
        return this.position.getAmount() == position;
    }

    public void moveForwardIfTrue(boolean isForward) {
        if (isForward) {
            position.increment();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getAmount();
    }

    @Override
    public String toString() {
        return name.getName() + " : " + CAR_POSITION_SIGN.repeat(position.getAmount());
    }
}