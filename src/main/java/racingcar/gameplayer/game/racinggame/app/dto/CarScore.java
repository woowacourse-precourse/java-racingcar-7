package racingcar.gameplayer.game.racinggame.app.dto;

import racingcar.gameplayer.game.racinggame.domain.car.Name;
import racingcar.gameplayer.game.racinggame.domain.car.Position;

public record CarScore(String name, Long position) {

    public static CarScore of(Name name, Position position) {
        return new CarScore(name.name(), position.getNumber());
    }
}
