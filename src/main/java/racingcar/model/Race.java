package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.rule.RaceRule;

public class Race {

    private final List<Car> cars;
    private final int totalRounds;
    private final RaceRule raceRule;
    private int currentRounds;

    public Race(List<Car> cars, int totalRounds, RaceRule raceRule) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        this.raceRule = raceRule;
        this.currentRounds = 0;
    }

    public void playRound() {
        cars.forEach(this::driveCarOneStep);
        currentRounds++;
    }

    public boolean isRaceOver() {
        return currentRounds >= totalRounds;
    }

    public List<String> createWinnerNameList() {
        int maxDistance = getMaxDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대 거리를 찾을 수 없습니다."));
    }

    private void driveCarOneStep(Car car) {
        if (raceRule.isMovePermitted()) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
