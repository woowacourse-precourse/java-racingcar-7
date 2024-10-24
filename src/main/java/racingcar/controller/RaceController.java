package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.request.CarCreateRequest;
import racingcar.service.RaceService;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService service;
    private final OutputView view;

    public RaceController(CarCreateRequest carCreateRequest) {
        service = new RaceService(carCreateRequest);
        view = new OutputView();
    }

    public void execute() {
        do {
            List<Car> cars = service.proceed();
            view.displayMessage(cars.toString());
        } while (!service.isGameEnd());
        view.displayMessage("우승자 : " + service.getWinner().toString());
    }
}
