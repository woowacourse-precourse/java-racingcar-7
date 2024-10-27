package racingcar.ui;

import java.util.List;
import racingcar.ui.dto.GetFinalWinnerDto;
import racingcar.ui.dto.GetRacingResultDto;

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

    public void showRacingResult(List<GetRacingResultDto> response) {
        response.forEach(racingResult -> BUFFER.append(racingResult.carName())
                .append(" : ")
                .append("-".repeat(racingResult.position()))
                .append(NEW_LINE));

        bufferClear();
        newLine();
    }

    private void bufferClear() {
        System.out.print(BUFFER);
        BUFFER.setLength(0);
    }

    public void showFinalWinners(GetFinalWinnerDto response) {
        BUFFER.append("최종 우승자 : ")
                .append(String.join(", ", response.finalWinners()))
                .append(NEW_LINE);

        bufferClear();
    }

}
