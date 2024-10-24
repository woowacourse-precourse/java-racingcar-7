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
        for (int i = 0; i < game.getGameRound(); i++) {
            GameResult result = game.playRound();
            if (i == 0) {
                outputView.printRoundResultMessage();
            }
            outputView.printRoundResult(result);
        }
    }
}
