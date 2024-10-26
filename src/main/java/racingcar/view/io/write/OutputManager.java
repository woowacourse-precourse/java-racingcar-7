package racingcar.view.io.write;

import static racingcar.common.message.OutputMessage.LAP_CHART_RESULT;
import static racingcar.common.message.OutputMessage.RACE_WINNERS;

import racingcar.view.DashBoardView;

public class OutputManager {

    // Constructor
    private OutputManager() {
    }

    public static class OutputManagerHolder {
        private final static OutputManager INSTANCE = new OutputManager();
    }

    public static OutputManager getInstance() {
        return OutputManagerHolder.INSTANCE;
    }

    // Method
    public void showLapCharts(final DashBoardView view) {
        OutputView instance = OutputView.getInstance();
        instance.printWithNewLineUpper(LAP_CHART_RESULT);
        instance.printWithNewLineLower(view.getLapCharts());
    }

    public void showWinners(final DashBoardView view) {
        OutputView instance = OutputView.getInstance();
        String resultMessage = String.format(RACE_WINNERS, view.getWinners());
        instance.simplePrint(resultMessage);
        instance.closeConsole();
    }
}
