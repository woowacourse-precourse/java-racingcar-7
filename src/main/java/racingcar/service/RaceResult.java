package racingcar.service;

import java.util.List;

public record RaceResult(List<List<Integer>> roundPositions, List<String> winners) {
}
