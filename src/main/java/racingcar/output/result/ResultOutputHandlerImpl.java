package racingcar.output.result;

import racingcar.executor.decider.winner.WinnerListDecider;

import java.util.List;
import java.util.Map;

public class ResultOutputHandlerImpl implements ResultOutputHandler {

    private final WinnerListDecider winnerListDecider;

    public ResultOutputHandlerImpl(WinnerListDecider winnerListDecider) {
        this.winnerListDecider = winnerListDecider;
    }

    @Override
    public void printWinner(Map<String, Integer> history) {
        List<String> winners = winnerListDecider.findWinners(history);
        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }
}
