package racingcar.model;

import java.util.List;

public record RaceResult(RaceProgress roundPositions, List<String> winners) {
}