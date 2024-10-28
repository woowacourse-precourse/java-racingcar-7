package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Utils utils = new Utils();

        String[] carNames = inputView.getCarNames();
        int limit = inputView.getRoundLimit();

        RacingGame racingGame = new RacingGame(limit, outputView, utils);
        racingGame.setParticipants(carNames);

        racingGame.playGame();
        Console.close();
    }
}
