package racingcar.racingGame;

import racingcar.car.Car;
import racingcar.car.CarImpl;

import java.util.ArrayList;
import java.util.List;

import static racingcar.utils.InputSplitter.inputSplit;

public class RacingGameImpl implements RacingGame{
    private final List<Car> racingCars = new ArrayList<>();

    public RacingGameImpl(String inputRacingCarsName) {
        List<String> carsName = inputSplit(inputRacingCarsName);

        for (String carName : carsName) {
            racingCars.add(new CarImpl(carName));
        }
    }

    @Override
    public List<Car> moveRacingCars(List<Integer> randomNumbers) {
        return null;
    }

    @Override
    public List<Car> getWinners() {
        return null;
    }

    @Override
    public int getNumberOfRacingCars() {
        return racingCars.size();
    }
}
