package racingcar.domain.racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.ArrayList;

public class Race {

    private final List<Car> cars;
    private final int totalRounds;
    private int currentRound;

    private Race(List<String> carNames, int totalRounds) {
        this.cars = createCars(carNames);
        this.totalRounds = validateTotalRounds(totalRounds);
        this.currentRound = 0;
    }

    public static Race of(List<String> carNames, int totalRounds) {
        return new Race(carNames, totalRounds);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.of(name));
        }
        return cars;
    }

    private int validateTotalRounds(int totalRounds) {
        if (totalRounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        return totalRounds;
    }

    public void moveAllCars() {
        for (Car car : cars) {
            car.move(pickNumberInRange(0, 9));
        }
        currentRound++;
    }

    public boolean isRaceFinished() {
        return currentRound >= totalRounds;
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public int getTotalRounds() {
        return totalRounds;
    }

    public int getCurrentRound() {
        return currentRound;
    }
}