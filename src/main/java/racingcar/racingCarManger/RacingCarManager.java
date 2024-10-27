package racingcar.racingCarManger;

import racingcar.car.Car;

import java.util.List;

public interface RacingCarManager {
    public List<Car> moveRacingCars(List<Integer> randomNumbers);

    public List<Car> getWinners();

    public int getNumberOfRacingCars();
}
