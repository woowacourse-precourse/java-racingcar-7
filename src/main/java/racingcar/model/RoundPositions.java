package racingcar.model;

import java.util.List;

public record RoundPositions(List<Integer> positions) {
    public RoundPositions(List<Integer> positions) {
        this.positions = List.copyOf(positions);
    }
}