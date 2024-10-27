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

    public List<List<CarInfo>> runGameRounds(GameRound gameRound, CarGroup carGroup) {
        List<List<CarInfo>> roundResult = new ArrayList<>();
        for (int currentRound = 1; currentRound <= gameRound.getRound(); currentRound++) {
            gameManager.moveCarsBasedOnRule(carGroup);
            roundResult.add(gameManager.retrieveCarStatus(carGroup));
        }
        return roundResult;
    }

    public List<String> getWinners(CarGroup carGroup) {
        return gameManager.determineWinners(carGroup);
    }

}
