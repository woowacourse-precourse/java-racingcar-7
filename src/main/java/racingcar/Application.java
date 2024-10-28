package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.RoundProcessResultView;
import racingcar.view.WinnerView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.readNamesInput();
        int numberRounds = InputView.readMoveNumInput();

        RacingGame racingGame = new RacingGame(carNames);

        for(int round = 0; round < numberRounds; round++){
            racingGame.raceOneRound();
            RoundProcessResultView.displayRoundResult(racingGame.getCars());
        }

        List<Racingcar> winners = racingGame.finalWinner();
        WinnerView.showWinners(winners);
    }
}
