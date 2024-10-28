package racingcar.modle.vehicle;

import racingcar.movableStrategy.MoveStrategy;

public interface Movable {
    public Movable move(MoveStrategy moveStrategy);

    public String getName();

    public int getPosition();

}
