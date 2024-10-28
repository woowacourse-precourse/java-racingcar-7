package racingcar.mvc.view;

import java.util.List;
import racingcar.mvc.model.observer.Racer;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void showExecutionResultMsg() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public void showRacersStatus(List<Racer> racers) {
        for (Racer racer : racers) {
            System.out.println(racer);
        }
        System.out.println();
    }

    public void showFinalWinnerMsg(String winners) {
        System.out.print(FINAL_WINNER_MESSAGE);
        System.out.println(winners);
    }
}
