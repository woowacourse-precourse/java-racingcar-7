package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceWinner {

    public static List<String> calculateWinners(List<String> carNames, List<Integer> carPositions) {
        int maxForward = carPositions.stream()
                .max(Integer::compareTo)
                .orElse(0);

        // 최대 거리와 동일한 자동차를 찾는 메서드
        return IntStream.range(0, carPositions.size())
                .filter(i -> carPositions.get(i) == maxForward)
                .mapToObj(carNames::get)
                .collect(Collectors.toList());
    }
}