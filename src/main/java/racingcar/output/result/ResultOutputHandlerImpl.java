package racingcar.output.result;

import racingcar.entity.Car;
import racingcar.executor.decider.winner.WinnerListDecider;

import java.util.List;

public class ResultOutputHandlerImpl implements ResultOutputHandler {

    private final WinnerListDecider winnerListDecider;

    public ResultOutputHandlerImpl(WinnerListDecider winnerListDecider) {
        this.winnerListDecider = winnerListDecider;
    }

    @Override
    public void printWinner(List<Car> history) {
        List<String> winners = winnerListDecider.findWinners(history);
        System.out.println("\n최종 우승자 : " + String.join(", ", winners));
    }
}
