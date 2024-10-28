package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceProgress {
    private final List<RoundPositions> progress = new ArrayList<>();

    public void addRoundPositions(List<Integer> positions) {
        progress.add(new RoundPositions(positions));
    }

    public List<RoundPositions> getProgress() {
        return List.copyOf(progress);
    }
}