package racingcar.domain;

import java.util.Comparator;
import java.util.List;

public class GameResult {
    public static List<String> findWinners(List<RacingHistory> histories) {
        int winnerDistance = histories.stream()
                .max(Comparator.comparingInt(RacingHistory::getDistance))
                .orElseThrow(() -> new IllegalArgumentException("가장 많은 이동거리를 가진 차가 없습니다."))
                .getDistance();

        return histories.stream()
                .filter(history -> history.getDistance() == winnerDistance)
                .map(RacingHistory::getName)
                .toList();
    }
}
