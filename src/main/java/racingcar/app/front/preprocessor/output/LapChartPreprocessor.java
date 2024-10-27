package racingcar.app.front.preprocessor.output;

import java.util.List;

public class LapChartPreprocessor {
    private LapChartPreprocessor() {
    }

    public static String stringListToString(final List<String> lapCharts) {
        return String.join("\n\n", lapCharts);
    }
}
