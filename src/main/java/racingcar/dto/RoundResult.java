package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    public List<String> carNames;
    public List<Integer> carPositions;

    public RoundResult() {
        carNames = new ArrayList<>();
        carPositions = new ArrayList<>();
    }
}
