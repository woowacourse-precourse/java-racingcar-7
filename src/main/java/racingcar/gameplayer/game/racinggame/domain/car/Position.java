package racingcar.gameplayer.game.racinggame.domain.car;

import racingcar.gameplayer.game.common.domain.PositiveNumber;

public class Position extends PositiveNumber {

    public static final Position ZERO = new Position(0L);
    public static final Position ONE = new Position(1L);

    public Position(Long number) {
        super(number);
    }

    @Override
    public Position add(PositiveNumber other) {
        Long newNumber = super.add(other).getNumber();
        return new Position(newNumber);
    }
}
