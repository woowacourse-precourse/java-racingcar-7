package racingcar;

public class RacingGame {
    private final RacingInputView inputView;
    private final RacingOutputView outputView;

    public RacingGame(RacingInputView inputView, RacingOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        String carNamesInput = inputView.getCarNamesInput();
        CompeteCars competeCars = new CompeteCars(carNamesInput);

        Integer moveCount = inputView.getMoveCount();
        Round round = new Round(moveCount, competeCars);

        outputView.printResultString();
        while (round.getMoveCount() > 0) {
            round.progress();
            outputView.printRoundResult(round.getResult());
        }
        outputView.printWinners(round.getWinners());
    }
}
