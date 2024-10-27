package racingcar;

import java.util.List;

public record RoundResult(List<Position> positions) {

    public List<Integer> extractResults() {
        return positions.stream()
                .map(Position::getPosition)
                .toList();
    }
}
