package racingcar.app.front.model;

import java.util.List;
import racingcar.app.front.preprocessor.output.LapChartPreprocessor;
import racingcar.app.front.preprocessor.output.WinnerPreprocessor;
import racingcar.app.front.view.OutputView;
import racingcar.app.middleware.dto.OutputDTO;

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

    public void showRaceResult(OutputDTO outputs) {
        OutputView outputView = OutputView.getInstance();
        showLapCharts(outputView, outputs.lapCharts());
        showWinners(outputView, outputs.winners());
    }

    private void showLapCharts(final OutputView outputView, final List<String> source) {
        String responseMessage = LapChartPreprocessor.stringListToString(source);

        outputView.printWithNewLineBefore(LAP_CHART_RESULT);
        outputView.printWithNewLineAfter(responseMessage);
    }

    private void showWinners(final OutputView outputView, final List<String> source) {
        String winners = WinnerPreprocessor.stringListToString(source);
        String responseMessage = generateWinnerMessageBy(winners);

        outputView.simplePrint(responseMessage);
        outputView.closeConsole();
    }

    private String generateWinnerMessageBy(final String winners) {
        if (winners.isEmpty()) {
            return String.format(RACE_WINNERS, NO_WINNER);
        }
        return String.format(RACE_WINNERS, winners);
    }
}
