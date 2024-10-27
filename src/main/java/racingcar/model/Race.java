package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class Race {
    private List<Car> cars;

    public Race(List<String> carNames) {
        cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    public void runRace(int attempCount) {
        for (int i = 0; i < attempCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            OutputView.showRaceStatus(cars);
        }
    }
}
