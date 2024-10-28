package racingcar;

public class BasicMovable implements Movable {
    @Override
    public boolean isMovable() {
        return Util.getRandom() >= 4;
    }
}
