package racingcar.gameplayer.game.racinggame;

import racingcar.gameplayer.game.Game;
import racingcar.gameplayer.game.racinggame.domain.car.Names;
import racingcar.gameplayer.game.common.domain.PositiveNumber;
import racingcar.gameplayer.game.racinggame.app.CarHandler;
import racingcar.gameplayer.game.racinggame.app.dto.GameResult;
import racingcar.gameplayer.game.racinggame.ui.helper.InputHelper;
import racingcar.gameplayer.game.racinggame.ui.helper.OutputHelper;

public class RacingGame implements Game {

    private final InputHelper inputHelper = new InputHelper();
    private final OutputHelper outputHelper = new OutputHelper();
    private final CarHandler carHandler = new CarHandler();

    public void play() {
        GameResult result = carHandler.handle(getNames(), getTryCount());
        outputHelper.printResult(result);
    }

    private PositiveNumber getTryCount() {
        return inputHelper.getTryCount();
    }

    private Names getNames() {
        return inputHelper.getNames();
    }
}
