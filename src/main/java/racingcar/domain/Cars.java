package racingcar.domain;

import racingcar.utils.CarNameParser;
import racingcar.utils.RoundResultGenerator;
import racingcar.utils.WinnerDeterminer;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        List<String> carNamesList = CarNameParser.parse(carNames);

        this.cars = convertToCars(carNamesList);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void play() {
        cars.forEach(Car::move);
    }

    public List<String> getRoundResults() {
        return RoundResultGenerator.generate(cars);
    }

    public List<String> getWinners() {
        return WinnerDeterminer.determineWinners(cars);
    }

    private static List<Car> convertToCars(List<String> carNamesList) {
        return carNamesList.stream()
                .map(Car::new)
                .toList();
    }
}
