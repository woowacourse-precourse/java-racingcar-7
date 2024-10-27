package racingcar.modle.movableStrategy;

public class BasicMoveStrategy implements MovableStrategy {
    private static final int BASIC_MOVE = 1;

    public int move(){
        return BASIC_MOVE;
    }
}
