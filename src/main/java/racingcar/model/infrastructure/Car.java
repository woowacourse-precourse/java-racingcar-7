package racingcar.model.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
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
    public void move() {
        int playNum = play();
        if (moveDecider.canMove(playNum)) {
            incrementDistance(MOVE_DISTANCE);
        }
    }

    @Override
    protected int play() {
        return Randoms.pickNumberInRange(0, 9);
    }
}