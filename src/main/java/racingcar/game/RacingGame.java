package racingcar.game;

import java.util.List;
import java.util.Map;
import racingcar.car.CompeteCars;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class RacingGame {
    private final RacingInputView inputView;
    private final RacingOutputView outputView;

    public RacingGame(RacingInputView inputView, RacingOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private CompeteCars makeCompeteCars() {
        List<String> carNames = inputView.getCarNames();
        return new CompeteCars(carNames);
    }

    private Round setRound(CompeteCars competeCars) {
        int moveCount = inputView.getMoveCount();
        return new Round(moveCount, competeCars);
    }

    public void play() {
        CompeteCars competeCars = makeCompeteCars();
        Round round = setRound(competeCars);

        outputView.printResultString();
        while (round.hasNext()) {
            round.progress();
            Map<String, Integer> roundResult = competeCars.getCarsCurrentPosition();
            outputView.printRoundResult(roundResult);
        }

        outputView.printWinners(competeCars.getWinnerCars());
    }
}
