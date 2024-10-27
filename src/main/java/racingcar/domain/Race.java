package racingcar.domain;

import racingcar.utils.RandomForwardGenerator;

import java.util.*;

import static racingcar.constants.RaceConstants.*;

public class Race {

    private final Map<String, Integer> carPositions;
    private final int forwardCount;

    private Race(Car car, int forwardCount) {
        this.carPositions = new LinkedHashMap<>();
        this.forwardCount = forwardCount;
        setInitialPositions(car);
    }

    public static Race of(Car car, int forwardCount) {
        return new Race(car, forwardCount);
    }

    public String startRace() {
        StringBuilder result = new StringBuilder(RACE_EXECUTION_RESULT_HEADER);
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
                    .append(CAR_NAME_POSITION_SEPARATOR)
                    .append(CAR_POSITION_MARKER.repeat(carPositions.get(carName)))
                    .append(LINE_BREAK);
        }
        result.append(LINE_BREAK);
    }

    private void moveCar(String carName) {
        int randomPosition = RandomForwardGenerator.randomSingleDigitNumber();
        if (randomPosition >= CAR_MOVE_THRESHOLD) {
            carPositions.put(carName, carPositions.get(carName) + CAR_MOVE_INCREMENT);
        }
    }

    private void appendWinners(StringBuilder result) {
        int maxPosition = carPositions.values()
                .stream()
                .max(Integer::compareTo)
                .orElse(DEFAULT_VALUE);

        result.append(FINAL_WINNER_MESSAGE)
                .append(String.join(WINNER_NAME_SEPARATOR, findWinners(maxPosition)));
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
                .forEach(carName -> carPositions.put(carName, DEFAULT_VALUE));
    }

}