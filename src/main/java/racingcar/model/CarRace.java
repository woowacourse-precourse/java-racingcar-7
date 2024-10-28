package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRace {
    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final int MAX_ATTEMPT_COUNT = 100;

    private final List<CarRaceSnapshot> carRaceSnapshots;
    private final List<String> finalWinners;
    private final int attemptCount;

    public CarRace(final int attemptCount) {
        validateAttemptCountRange(attemptCount);
        this.attemptCount = attemptCount;
        this.carRaceSnapshots = new ArrayList<>();
        this.finalWinners = new ArrayList<>();
    }

    public void startRace(final Cars cars) {
        for (int i = 0; i < attemptCount; i++) {
            runRaceRound(cars);
        }
        determineWinners(getLastRoundSnapshot());
    }

    private void runRaceRound(final Cars cars) {
        cars.moveCars();
        CarRaceSnapshot carRaceSnapshot = new CarRaceSnapshot(cars);
        carRaceSnapshots.add(carRaceSnapshot);
    }

    private void determineWinners(CarRaceSnapshot carRaceSnapshot) {
        finalWinners.addAll(carRaceSnapshot.getMaxDistanceCarsName());
    }

    private CarRaceSnapshot getLastRoundSnapshot() {
        return carRaceSnapshots.get(carRaceSnapshots.size() - 1);
    }

    public List<CarRaceSnapshot> getCarRaceSnapshots() {
        return Collections.unmodifiableList(carRaceSnapshots);
    }

    public List<String> getFinalWinners() {
        return finalWinners;
    }

    private void validateAttemptCountRange(final int attemptCount) {
        validateAttemptCountIsAtLeastMin(attemptCount);
        validateAttemptCountIsAtMostMax(attemptCount);
    }

    private void validateAttemptCountIsAtLeastMin(final int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 " + MIN_ATTEMPT_COUNT + " 이상이어야 합니다.");
        }
    }

    private void validateAttemptCountIsAtMostMax(final int attemptCount) {
        if (attemptCount > MAX_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 " + MAX_ATTEMPT_COUNT + " 이하이어야 합니다.");
        }
    }
}
