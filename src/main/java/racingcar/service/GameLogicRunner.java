package racingcar.service;

import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.model.GameLogicTransform;
import racingcar.model.GameLogicValidation;

public class GameLogicRunner {
    private static final Map<String, Integer> resultMap = new LinkedHashMap<>();
    private final GameLogicTransform gameLogicTransform = new GameLogicTransform(resultMap);
    private final GameLogicValidation gameLogicValidation = new GameLogicValidation(resultMap);

    public GameLogicRunner(String carName) {
        gameLogicTransform.mapByCarName(carName);
    }

    public Map<String, Integer> getOneTryResult() {
        gameLogicTransform.updateMapByResult();
        return resultMap;
    }

    public String getFinalWinner() {
        return gameLogicValidation.findRacingWinner();
    }
}
