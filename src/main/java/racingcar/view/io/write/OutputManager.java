package racingcar.view.io.write;

import racingcar.view.DashBoardView;

public class OutputManager {

    private static final String LAP_CHART_RESULT = "실행 결과";
    private static final String RACE_WINNERS = "최종 우승자 : %s";
    private static final String NO_WINNER = "우승자가 없습니다.";

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
        String resultMessage = String.format(RACE_WINNERS, NO_WINNER);

        String offeredLWinners = view.getWinners();
        if (winnerExistOn(offeredLWinners)) {
            resultMessage = String.format(RACE_WINNERS, view.getWinners());
        }

        instance.simplePrint(resultMessage);
        instance.closeConsole();
    }

    private boolean winnerExistOn(String offeredLWinners) {
        return !offeredLWinners.isBlank();
    }
}
