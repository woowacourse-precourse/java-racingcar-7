package racingcar.view;

import java.util.List;
import racingcar.domain.RaceRound;
import racingcar.dto.ViewDto;

public class RacingGameView {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameView() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public ViewDto startGame() {
        return ViewDto.of(inputView.readCarNames(), inputView.readTryCount());
    }

    public void endGame(List<RaceRound> raceRounds, String winnerCarName) {
        outputView.printGameStart();
        outputView.printRaceResult(raceRounds);
        outputView.printWinners(winnerCarName);
    }

}
