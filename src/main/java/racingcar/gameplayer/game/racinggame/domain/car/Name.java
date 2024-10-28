package racingcar.gameplayer.game.racinggame.domain.car;

import racingcar.gameplayer.game.common.exception.CustomException;
import racingcar.gameplayer.game.common.exception.ErrorMessage;

public record Name(String name) {

    public static final int MAX_NAME_LENGTH = 5;

    public Name {
        valid(name);
    }

    private void valid(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new CustomException(ErrorMessage.NAME_SHORT_LENGTH_ERROR);
        }
    }
}
