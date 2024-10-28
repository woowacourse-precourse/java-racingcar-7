package racingcar.gameplayer.game.racinggame.app;

import racingcar.gameplayer.game.racinggame.domain.car.Names;
import racingcar.gameplayer.game.common.domain.PositiveNumber;
import racingcar.gameplayer.game.racinggame.domain.car.Cars;
import racingcar.gameplayer.game.racinggame.app.dto.GameResult;

public class CarHandler {

    public GameResult handle(Names names, PositiveNumber roundCount) {
        Cars cars = new Cars(names);
        return cars.proceedRound(roundCount);
    }
}
