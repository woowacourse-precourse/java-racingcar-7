package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.CarInfo;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameManager;
import racingcar.domain.game.Round;

public class RacingGameService {
    private final GameManager gameManager;

    public RacingGameService(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public List<List<CarInfo>> playRound(Round round, Cars cars) {
        List<List<CarInfo>> roundResult = new ArrayList<>();

        for (int i = 0; i < round.getRound(); i++) {
            gameManager.moveCarsBasedOnRule(cars);
            roundResult.add(gameManager.retrieveCarStatus(cars));
        }

        return roundResult;
    }

    public List<String> getWinner(Cars cars) {
        return gameManager.determineWinners(cars);
    }

}
