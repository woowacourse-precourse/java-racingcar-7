package racingcar;

public class Gasoline implements Engine {

    private final int moveDistance;

    public Gasoline(int moveDistance) {
        this.moveDistance = moveDistance;
    }

    @Override
    public int accelerate() {
        return moveDistance;
    }
}
