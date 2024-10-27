package racingcar.app.front.model;

import racingcar.app.front.view.OutputView;

public class OutputManager {

    private static final String LAP_CHART_RESULT = "실행 결과";
    private static final String RACE_WINNERS = "최종 우승자 : %s";
    private static final String NO_WINNER = "우승자가 없습니다.";

    private OutputManager() {
    }

    public static class OutputManagerHolder {
        private final static OutputManager INSTANCE = new OutputManager();
    }

    public static OutputManager getInstance() {
        return OutputManagerHolder.INSTANCE;
    }

    public void showLapCharts(final String lapCharts) {
        OutputView instance = OutputView.getInstance();
        instance.printWithNewLineUpper(LAP_CHART_RESULT);
        instance.printWithNewLineLower(lapCharts);
    }

    public void showWinners(final String winners) {
        OutputView instance = OutputView.getInstance();
        String resultMessage = String.format(RACE_WINNERS, NO_WINNER);

        if (winnerExistOn(winners)) {
            resultMessage = String.format(RACE_WINNERS, winners);
        }

        instance.simplePrint(resultMessage);
        instance.closeConsole();
    }

    private boolean winnerExistOn(final String offeredLWinners) {
        return !offeredLWinners.isBlank();
    }
}
