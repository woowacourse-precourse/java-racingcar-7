package racingcar.model.dto;

import java.util.List;

public class RacingResult {

    private final List<String> result;

    public RacingResult(List<String> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.join("\n", result);
    }
}
