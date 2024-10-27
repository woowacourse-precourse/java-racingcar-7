package racingcar;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class RacingCarTrace {
    private final Map<RacingCar, Integer> trace = new LinkedHashMap<>();

    public void put(RacingCar racingCar) {
        validateDuplicateName(racingCar);
        trace.put(racingCar, 0);
    }

    private void validateDuplicateName(RacingCar racingCar) {
        if (trace.containsKey(racingCar)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public void forwardOrStop(RacingCar racingCar, int randomNumber) {
        if (randomNumber >= 4) {
            trace.put(racingCar, trace.get(racingCar) + 1);
        }
    }

    public RacingCar getRacingCar(int index) {
        return trace.keySet().stream()
                .skip(index)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String traceToString() {
        var sb = new StringBuilder();
        IntStream.range(0, trace.size()).forEach(index -> {
            var racingCar = this.getRacingCar(index);
            sb.append(racingCar.name()).append(" : ")
                    .append("-".repeat(this.getDistance(racingCar)))
                    .append("\n");
        });
        sb.append("\n");
        return sb.toString();
    }

    public int getDistance(RacingCar racingCar) {
        return trace.get(racingCar);
    }

    public List<RacingCar> getBiggestDistanceRacingCar() {
        var max = trace.values().stream().max(Integer::compare).orElse(0);
        return trace.keySet().stream()
                .filter(racingCar -> trace.get(racingCar).equals(max))
                .toList();
    }

    public int size() {
        return trace.size();
    }
}