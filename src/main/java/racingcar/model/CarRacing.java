package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;

public class CarRacing {
    private final List<Car> carList = new ArrayList<>();
    private final InputView inputView;

    public CarRacing(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        List<String> carNameList = inputView.inputCarNames();

        carNameList.forEach(this::enroll);
    }

    private void enroll(String name) {
        carList.add(Car.of(name));
    }
}
