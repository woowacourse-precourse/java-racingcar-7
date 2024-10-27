package racingcar.config;

import racingcar.model.car.Cars;
import racingcar.model.game.Game;
import racingcar.model.game.PositionBasedReferee;
import racingcar.model.game.RandomNumberPicker;
import racingcar.model.game.TotalRounds;

public class GameFactory {
    public static Game create(String[] carNames, int totalRounds) {
        return new Game(new Cars(carNames), new TotalRounds(totalRounds), new RandomNumberPicker(),
                new PositionBasedReferee());
    }
}
