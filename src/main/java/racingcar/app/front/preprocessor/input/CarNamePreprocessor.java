package racingcar.app.front.preprocessor.input;

import java.util.Arrays;
import java.util.List;

public class CarNamePreprocessor {

    private CarNamePreprocessor() {
    }

    public static List<String> stringToStringList(final String source) {
        return Arrays.stream(source.split(","))
                .map(String::strip)
                .map(val -> val.replaceAll("\\s", ""))
                .toList();
    }
}
