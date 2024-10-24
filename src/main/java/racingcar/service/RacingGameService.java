package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;

public class RacingGameService {
    private final InputView inputView = new InputView();
    public List<Car> inputCars() {

        List<String> carNames = inputView.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            name = name.trim();
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
            cars.add(new Car(name));
        }

        return cars;
    }

    public void announceWinners() {
        List<String> winners = racingGameService.getWinners();
        outputView.printWinners(winners);
    }
}
