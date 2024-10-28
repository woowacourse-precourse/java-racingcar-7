package racingcar.game;

import java.util.List;
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
        Integer moveCount = inputView.getMoveCount();
        return new Round(moveCount, competeCars);
    }

    public void play() {
        CompeteCars competeCars = makeCompeteCars();
        Round round = setRound(competeCars);

        outputView.printResultString();
        while (round.hasNext()) {
            round.progress();
            outputView.printRoundResult(competeCars.getCarsCurrentPosition());
        }

        outputView.printWinners(competeCars.getWinnerCars());
    }
}
