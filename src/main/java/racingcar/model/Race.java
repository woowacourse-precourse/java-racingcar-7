package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private static final int MOVE_DISTANCE = 1;
    private static final int CAR_MOVE_THRESHOLD = 4;
    private final List<Car> participatingCars;
    private final int totalRounds;

    public Race(List<Car> participatingCars, int totalRounds) {
        this.participatingCars = participatingCars;
        this.totalRounds = totalRounds;
    }

    public List<Car> getParticipatingCars() {
        return participatingCars;
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public List<Car> startEachRound(List<Car> participatingCars) {
        for (Car car : participatingCars) {
            updateCarDistance(car);
        }
        return participatingCars;
    }

    private void updateCarDistance(Car car) {
        if (canCarMove()) {
            car.setDistance(car.getDistance() + MOVE_DISTANCE);
        }
    }

    private boolean canCarMove() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum >= CAR_MOVE_THRESHOLD;
    }

    public List<String> getWinners(List<Car> participatingCars) {
        int maxDistance = findMaxLocation(participatingCars);
        return participatingCars.stream().filter(car -> car.getDistance() == maxDistance).map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findMaxLocation(List<Car> participatingCars) {
        return participatingCars.stream().mapToInt(Car::getDistance).max().orElse(0);
    }
}
