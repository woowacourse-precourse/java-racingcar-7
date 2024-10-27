package racingcar.util;

public class FixedMoveStrategy implements MoveStrategy{
    private final boolean movable;

    public FixedMoveStrategy(boolean movable){
        this.movable = movable;
    }

    @Override
    public boolean isMovable(){
        return movable;
    }
}
