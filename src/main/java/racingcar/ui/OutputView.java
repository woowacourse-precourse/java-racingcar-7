package racingcar.ui;

import java.util.List;
import racingcar.domain.round.RoundResult;

public class OutputView {

    private static final StringBuilder BUFFER = new StringBuilder();
    private static final String NEW_LINE = "\n";

    private void newLine() {
        System.out.println();
    }

    public void showPlayGame() {
        newLine();
        System.out.println("실행 결과");
    }

    public void showRacingResult(List<RoundResult> racingResult) {
        racingResult.forEach(roundResult -> BUFFER.append(roundResult.carName())
                .append(" : ")
                .append("-".repeat(roundResult.position()))
                .append(NEW_LINE));

        bufferClear();
        newLine();
    }

    private void bufferClear() {
        System.out.print(BUFFER);
        BUFFER.setLength(0);
    }

    public void showFinalWinners(List<String> finalWinners) {
        BUFFER.append("최종 우승자 : ")
                .append(String.join(", ", finalWinners))
                .append(NEW_LINE);

        bufferClear();
    }

}
