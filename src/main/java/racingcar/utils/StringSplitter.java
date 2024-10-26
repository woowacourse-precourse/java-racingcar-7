package racingcar.utils;

import java.util.List;

public class StringSplitter {
    public List<String> split(String carNames) {
        return List.of(carNames.split(","));
    }
}
