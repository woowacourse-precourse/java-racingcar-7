package racingcar.view.io.write;

import static racingcar.common.message.OutputMessage.RACE_WINNERS;
import static racingcar.view.io.write.OutputView.closeConsole;
import static racingcar.view.io.write.OutputView.newLine;
import static racingcar.view.io.write.OutputView.print;

public class OutputManager {

    public static void showLapChart(final String source) {
        print(source);
        newLine();
    }

    public static void showWinners(final String source) {
        String resultMessage = String.format(RACE_WINNERS, source);
        print(resultMessage);
        closeConsole();
    }
}
