package racingcar.modle.movableStrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class BasicMoveStrategy implements MovableStrategy {
    private static final int MOVEMENT_POINT = 1;
    private static final int MOVING_STANDARD_POINT= 4;
    private static final int START_NUMBER= 0;
    private static final int END_NUMBER= 9;

    @Override
    public int movePoint(){
        return MOVEMENT_POINT;
    }

    @Override
    public Boolean isMove(){
        int motionValue = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        return motionValue >= MOVING_STANDARD_POINT;
    }
}
