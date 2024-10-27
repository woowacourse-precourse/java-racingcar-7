package racingcar.model.dto;

import java.util.List;

public class RoundResult {

    private final List<String> result;

    private RoundResult(List<String> result) {
        this.result = result;
    }

    public List<String> getResultList() {
        return result;
    }

    public static RoundResult of(List<String> result) {
        return new RoundResult(result);
    }
}
