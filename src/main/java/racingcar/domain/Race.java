package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
public class Race {

    private final Cars cars;
    private final TrialCounts trialCounts;
    private int currentCounts;
    private int maxPosition;

    public Race(Cars cars, TrialCounts trialCounts) {
        this.cars = cars;
        this.trialCounts = trialCounts;
        this.currentCounts = 0;
        this.maxPosition = 0;
    }
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }

    private void moveCars() {
        for(Car car : cars.getCars()) {
            car.move(getRandomNumber());
        }
    }

    private void updateMaxPosition() {
        for(Car car : cars.getCars()) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }
    public void raceOneStep() {
        moveCars();
        updateMaxPosition();
        currentCounts++;
    }

    public boolean isRaceOngoing() {
        return currentCounts < trialCounts.getTrialCounts();
    }

    public int getMaxPosition() {
        return maxPosition;
    }
}
