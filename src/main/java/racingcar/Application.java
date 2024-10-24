package racingcar;

import racingcar.controller.RaceController;
import racingcar.request.CarCreateRequest;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        CarCreateRequest request = InputView.readCars();
        RaceController controller = new RaceController(request);
        controller.execute();
    }
}
