package racingcar.model.infrastructure;

import racingcar.model.domain.Decider;
import racingcar.model.domain.Vehicle;

public class Car extends Vehicle {
    private final Decider moveDecider;
    private final static Integer MOVE_DISTANCE = 1;

    public Car(String name,int distance, Decider moveDecider) {
        super(name,distance);
        this.moveDecider = moveDecider;
    }

    @Override
    public boolean move(int raceScore) {
        if (moveDecider.canMove(raceScore)) {
            incrementDistance(MOVE_DISTANCE);
            return true;
        }else{
            return false;
        }
    }
}