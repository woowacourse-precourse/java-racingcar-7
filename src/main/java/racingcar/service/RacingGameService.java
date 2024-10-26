package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.CarGroup;
import racingcar.domain.car.CarInfo;
import racingcar.domain.game.GameManager;
import racingcar.domain.game.GameRound;

public class RacingGameService {
    private final GameManager gameManager;

    public RacingGameService(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public List<List<CarInfo>> playRound(GameRound gameRound, CarGroup carGroup) {
        List<List<CarInfo>> roundResult = new ArrayList<>();

        for (int i = 0; i < gameRound.getRound(); i++) {
            gameManager.moveCarsBasedOnRule(carGroup);
            roundResult.add(gameManager.retrieveCarStatus(carGroup));
        }

        return roundResult;
    }

    public List<String> getWinner(CarGroup carGroup) {
        return gameManager.determineWinners(carGroup);
    }

}
