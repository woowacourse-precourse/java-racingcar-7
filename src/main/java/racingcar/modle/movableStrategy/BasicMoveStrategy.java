package racingcar.modle.movableStrategy;

public class BasicMoveStrategy implements MovableStrategy {
    private static final int MOVEMENT_POINT = 1;

    public int move(){
        return MOVEMENT_POINT;
    }
}
