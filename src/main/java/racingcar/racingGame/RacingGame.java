package racingcar.racingGame;

import racingcar.car.Car;

import java.util.List;

public interface RacingGame {
    public List<Car> moveRacingCars(List<Integer> randomNumbers);

    public List<Car> getWinners();

    public int getNumberOfRacingCars();
}
