package racingcar.view.io.write;

import static racingcar.common.message.OutputMessage.LAP_CHART_RESULT;
import static racingcar.common.message.OutputMessage.RACE_WINNERS;
import static racingcar.view.io.write.OutputView.closeConsole;
import static racingcar.view.io.write.OutputView.newLine;
import static racingcar.view.io.write.OutputView.print;

public class OutputManager {

    public static void showLapCharts(final String source) {
        print(LAP_CHART_RESULT);
        print(source);
        newLine();
    }

    public static void showWinners(final String source) {
        String resultMessage = String.format(RACE_WINNERS, source);
        print(resultMessage);
        closeConsole();
    }
}
