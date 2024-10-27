package racingcar;

public class RacingGame {
    private final RacingInputView inputView;
    private final RacingOutputView outputView;

    public RacingGame(RacingInputView inputView, RacingOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private CompeteCars makeCompeteCars() {
        String carNamesInput = inputView.getCarNamesInput();
        return new CompeteCars(carNamesInput);
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
