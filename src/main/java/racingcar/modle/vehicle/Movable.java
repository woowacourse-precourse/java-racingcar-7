package racingcar.modle.vehicle;

import racingcar.movableStrategy.MoveStrategy;

public interface Movable {
    public Movable move(final MoveStrategy moveStrategy);

    public String getName();

    public int getPosition();

}
