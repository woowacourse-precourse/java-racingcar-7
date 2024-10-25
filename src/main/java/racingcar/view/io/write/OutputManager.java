package racingcar.view.io.write;

import static racingcar.common.message.OutputMessage.LAP_CHART_RESULT;
import static racingcar.common.message.OutputMessage.RACE_WINNERS;
import static racingcar.view.io.write.OutputView.closeConsole;
import static racingcar.view.io.write.OutputView.printWithNewLineLower;
import static racingcar.view.io.write.OutputView.printWithNewLineUpper;
import static racingcar.view.io.write.OutputView.simplePrint;

import racingcar.view.DashBoardView;

public class OutputManager {

    public static void showLapCharts(final DashBoardView view) {
        printWithNewLineUpper(LAP_CHART_RESULT);
        printWithNewLineLower(view.getLapCharts());
    }

    public static void showWinners(final DashBoardView view) {
        String resultMessage = String.format(RACE_WINNERS, view.getWinners());
        simplePrint(resultMessage);
        closeConsole();
    }
}
