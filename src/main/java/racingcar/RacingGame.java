package racingcar;

import java.util.List;

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

    private boolean isMoveCountLeft(Round round) {
        return round.getMoveCount() > 0;
    }

    public void play() {
        CompeteCars competeCars = makeCompeteCars();
        Round round = setRound(competeCars);

        outputView.printResultString();
        while (isMoveCountLeft(round)) {
            round.progress();
            outputView.printRoundResult(round.getResult());
        }

        outputView.printWinners(round.getWinners());
    }
}
