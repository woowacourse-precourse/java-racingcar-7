package racingcar.controller;

import java.util.List;
import racingcar.service.Find;
import racingcar.service.Game;
import racingcar.service.collection.RacingCar;

public class RacingCarController {

    private static final Game game = new Game();
    private static final Find find = new Find();

    public void gameStart(RacingCar racingCar) {
        game.start(racingCar);
    }

    public List<String> findWinner(RacingCar racingCar) {
        int furthestNumber = find.FurthestNumber(racingCar);

        return find.Winners(racingCar, furthestNumber);
    }
}
