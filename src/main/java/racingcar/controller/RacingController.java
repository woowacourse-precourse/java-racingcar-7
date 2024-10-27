package racingcar.controller;

import java.util.Set;
import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.util.Parser;
import racingcar.util.RandomNumberPicker;
import racingcar.view.RacingInputView;
import racingcar.view.RacingOutputView;

public class RacingController {

    private final RacingService racingService;
    private final RacingInputView inputView;
    private final RacingOutputView outputView;

    public RacingController(RacingService racingService, RacingInputView inputView, RacingOutputView outputView) {
        this.racingService = racingService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String namesInput = inputView.requestNamesInput();

        Set<Car> cars = racingService.createCars(namesInput);

        String countInput = inputView.requestCountInput();
        progress(countInput, cars);
    }

    private void progress(String countInput, Set<Car> cars) {
        int count = Parser.parseInt(countInput);

        for (int i = 0; i < count; i++) {
            cars.forEach(car -> {
                car.move(RandomNumberPicker.pick());
            });
        }
    }
}
