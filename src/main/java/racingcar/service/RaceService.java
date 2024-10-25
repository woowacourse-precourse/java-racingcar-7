package racingcar.service;

import racingcar.model.Car;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

import java.util.List;

public class RaceService {
    private final OutputView outputView;

    public RaceService() {
        this.outputView = new OutputView();
    }
    public void start(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            progressRound(cars);
            outputView.printRaceRound(cars);
        }
    }

    private void progressRound(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    public List<Car> getWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
