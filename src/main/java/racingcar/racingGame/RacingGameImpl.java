package racingcar.racingGame;

import racingcar.car.Car;
import racingcar.car.CarImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static racingcar.utils.InputSplitter.inputSplit;

public class RacingGameImpl implements RacingGame{
    private final List<Car> racingCars = new ArrayList<>();

    public RacingGameImpl(String inputRacingCarsName) {
        List<String> carsName = inputSplit(inputRacingCarsName);

        for (String carName : carsName) {
            checkDuplicationCarName(carName);
            racingCars.add(new CarImpl(carName));
        }
    }

    @Override
    public List<Car> moveRacingCars(List<Integer> randomNumbers) {
        IntStream.range(0, racingCars.size())
                .forEach(i -> racingCars.get(i).move(randomNumbers.get(i)));
        return List.copyOf(racingCars);
    }

    @Override
    public List<Car> getWinners() {
        return null;
    }

    @Override
    public int getNumberOfRacingCars() {
        return racingCars.size();
    }

    private void checkDuplicationCarName(String carName) {
        boolean isDuplicate = racingCars.stream()
                .anyMatch(racingCar -> racingCar.getCarName().equals(carName));

        if (isDuplicate) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다. 서로 다른 이름을 입력해주세요.");
        }
    }
}
