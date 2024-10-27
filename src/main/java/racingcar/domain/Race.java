package racingcar.domain;

import racingcar.utils.RandomForwardGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        appendWinners(result);
        return result.toString();
    }

    private void runAllRounds(StringBuilder result) {
        for (int i = 0; i < forwardCount; i++) {
            advanceCars();
            recordRoundResults(result);
        }
    }

    private void advanceCars() {
        for (String carName : carPositions.keySet()) {
            moveCar(carName);
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

    private void moveCar(String carName) {
        int randomPosition = RandomForwardGenerator.randomSingleDigitNumber();
        if (randomPosition >= 4) {
            carPositions.put(carName, carPositions.get(carName) + 1);
        }
    }

    private void appendWinners(StringBuilder result) {
        int maxPosition = carPositions.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(0);

        result.append("최종 우승자 : ")
                .append(String.join(", ", findWinners(maxPosition)));
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (String carName : carPositions.keySet()) {
            if (carPositions.get(carName) == maxPosition) {
                winners.add(carName);
            }
        }
        return winners;
    }

    private void setInitialPositions(Car car) {
        car.getCars()
                .forEach(carName -> carPositions.put(carName, 0));
    }

}