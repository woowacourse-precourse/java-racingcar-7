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
        List<String> carNames = Parser.parseCarName(input);
        Validator.carNamesValidate(carNames);
        return Cars.of(carNames);
    }

    public Integer getGameRoundInput(String input) {
        Validator.gameRoundValidate(input);
        return Integer.parseInt(input);
    }

    public void playGame(Game game, OutputView outputView) {
        GameResult result = game.playGame();

        printRoundResult(result, outputView);
        printWinners(result, outputView);
    }



    private void printRoundResult(GameResult result, OutputView outputView) {
        outputView.printResultNoticeMessage();
        outputView.printRoundResult(result);
    }

    private void printWinners(GameResult result, OutputView outputView) {
        Cars winners = getWinner(result);
        outputView.printWinner(winners);
    }

    private Cars getWinner(GameResult gameResult) {
        Cars lastRoundCars = gameResult.getCarsAtFinalRound();
        Integer maxMoveCount = gameResult.findMaxMoveCount();

        return lastRoundCars.findCarsByMoveCount(maxMoveCount);
    }
}
