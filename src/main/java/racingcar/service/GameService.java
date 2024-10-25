package racingcar.service;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.model.GameResult;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.OutputView;

public class GameService {

    public Cars createCars(String input) {
        List<String> carNames = Parser.parseCars(input);
        Validator.carNameValidate(carNames);

        return Cars.of(carNames);
    }

    public Integer getGameRoundInput(String input) {
        Validator.gameRoundValidate(input);
        return Integer.parseInt(input);
    }

    public void playGame(Game game, OutputView outputView) {
        GameResult result = null;
        for (int round = 0; round < game.getGameRound(); round++) {
            result = game.playRound();
            if (round == 0) {
                outputView.printRoundResultMessage();
            }
            outputView.printRoundResult(result);
        }
        Cars winners = getWinner(result);
        outputView.printWinner(winners);
    }

    private Cars getWinner(GameResult gameResult) {
        Cars joinCars = gameResult.getCars();

        Integer maxMoveCount = gameResult.findMaxMoveCount();
        return joinCars.findCarsByMoveCount(maxMoveCount);
    }
}
