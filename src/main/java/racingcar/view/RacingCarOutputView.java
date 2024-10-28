package racingcar.view;

import java.util.List;
import racingcar.model.RacingTrialLog;

public class RacingCarOutputView {
    public void printResult(List<RacingTrialLog> logs, List<String> winners) {
        printTrialLog(logs);
        printWinners(winners);
    }

    private void printTrialLog(List<RacingTrialLog> logs) {
        System.out.println("실행 결과");

        for (RacingTrialLog log : logs) {
            List<String> carNames = log.carNames();
            List<Integer> progresses = log.progresses();

            for (int i = 0; i < carNames.size(); i++) {
                System.out.println(
                    carNames.get(i) + " : " +
                        generateProgressDash(progresses.get(i))
                );
            }

            System.out.println();
        }
    }

    private String generateProgressDash(int progressNum) {
        return "-".repeat(progressNum);
    }

    private void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
