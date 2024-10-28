package racingcar.model;

import racingcar.policy.MovingPolicy;

public class RacingCar {

    private static final String DASH = "-";
    private final String name;
    private int position = 0;
    private final MovingPolicy policy;

    public RacingCar(String name) {
        this.name = name;
        this.policy = MovingPolicy.getCurrentPolicy();
    }

    public void move() {
        if (policy.isMoveable()){
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + DASH.repeat(position);
    }
}
