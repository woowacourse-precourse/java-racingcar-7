package racingcar.app.front.preprocessor.output;

import java.util.List;

public class WinnerPreprocessor {

    private WinnerPreprocessor() {
    }

    public static String stringListToString(final List<String> winners) {
        return String.join(", ", winners);
    }
}
