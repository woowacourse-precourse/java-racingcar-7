package racingcar.service;


import racingcar.domain.Car;

import java.util.List;

public class WinnerDeterminer {
    private final RaceManager raceManager;

    public WinnerDeterminer(RaceManager raceManager) {
        this.raceManager = raceManager;
    }

    //determineWinner()
    public List<Car> determineWinner() {
        int maxPosition = getMaxPositionInCars();
        return getCarsAtMaxPosition(maxPosition);
    }

    private int getMaxPositionInCars() {
        return raceManager.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Car> getCarsAtMaxPosition(int maxPosition) {
        return raceManager.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
