package racingcar.domain;

import racingcar.utils.RandomForwardGenerator;

import java.util.HashMap;
import java.util.Map;

public class Race {

    private final Map<String, Integer> carPositions;
    private final int forwardCount;

    private Race(Car car, int forwardCount) {
        this.carPositions = new HashMap<>();
        this.forwardCount = forwardCount;
        setInitialPositions(car);
    }

    public static Race of(Car car, int forwardCount) {
        return new Race(car, forwardCount);
    }

    public String startRace() {
        StringBuilder result = new StringBuilder("\n실행 결과\n");
        runAllRounds(result);
        return result.toString();
    }

    private void runAllRounds(StringBuilder result) {
        for (int i = 0; i < forwardCount; i++) {
            recordRoundResults(result);
        }
    }

    private void recordRoundResults(StringBuilder result) {
        for (String carName : carPositions.keySet()) {
            result.append(carName)
                    .append(" : ")
                    .append("-".repeat(carPositions.get(carName)))
                    .append("\n");
        }
        result.append("\n");
    }

    private void setInitialPositions(Car car) {
        car.getCars()
                .forEach(carName -> carPositions.put(carName, 0));
    }

}