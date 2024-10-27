package racingcar;

import racingcar.domain.Racing;
import racingcar.domain.RoundCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        Racing racing = Racing.from(INPUT_VIEW.inputCarNames());
        RoundCount roundCount = new RoundCount(INPUT_VIEW.inputRoundCount());

        OUTPUT_VIEW.outputRoundResultTitle();
        for (int currentRound = 1; currentRound <= roundCount.getCount(); currentRound++) {
            racing.progress();
            OUTPUT_VIEW.outputRoundResult(racing.getRoundResult());
        }
        OUTPUT_VIEW.outputWinners(racing.findWinner());
    }
}
