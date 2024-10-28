package model;

import service.MoveStrategy;
import service.RaceStatusCallback;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int attempts;
    private final List<String> winners;
    private final MoveStrategy moveStrategy;

    public List<Car> getCars() {
        return cars;
    }

    public Race(List<String> carNames, int attempts, MoveStrategy moveStrategy) {
        if (attempts < 0) {
            throw new IllegalArgumentException("attempts can't be less than 0");
        }
        this.cars = new ArrayList<>(carNames.size());
        this.attempts = attempts;
        this.moveStrategy = moveStrategy;
        this.winners = new ArrayList<>();

        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
    }

    public void attemptOnce() {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public void startRace(RaceStatusCallback callback) {
        for (int i = 0; i < attempts; i++) {
            attemptOnce();
            if (callback != null) {
                callback.onAttempt(new ArrayList<>(cars));
            }
        }
    }


    public List<String> getWinners() {
        int winnerPosition = getWinnerPosition();
        for (Car car : cars) {
            if (checkWinner(car, winnerPosition)) {
                addWinner(car);
            }
        }
        return winners;
    }

    private boolean checkWinner(Car car, int winnerPosition) {
        return (car.getPosition() == winnerPosition);
    }

    private void addWinner(Car car) {
        if (checkWinner(car, getWinnerPosition())) {
            winners.add(car.getName());
        }
    }

    public int getWinnerPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }
}