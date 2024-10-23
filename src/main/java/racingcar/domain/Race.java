package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

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

    private boolean goAndStop() {
        int randomNumber = Randoms.pickNumberInRange(0,9);
        return randomNumber >= 4;
    }

    private void moveCars() {
        for(Car car : cars.getCars()) {
            if(goAndStop()) {
                car.move();
            }
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
    }

    public void raceOneStep() {
        moveCars();
        currentCounts++;
    }

    public boolean isRaceOngoing() {
        return currentCounts < trialCounts.getTrialCounts();
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

}
