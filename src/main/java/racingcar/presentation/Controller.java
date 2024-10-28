package racingcar.presentation;

import racingcar.application.RacingCarService;
import racingcar.domain.car.value.Name;
import racingcar.domain.refree.value.TotalResult;

import java.util.List;

public class Controller {

    private final RacingCarService service;

    public Controller(RacingCarService service) {
        this.service = service;
    }

    public void addCars() {
        Viewer.enterCarNamesMessage();
        List<Name> names = InputReader.readCarNames();
        service.addCars(names);
    }

    public void startRace() {
        Viewer.enterCountMessage();
        TotalResult totalResult = service.startRace(InputReader.readCount());
        Viewer.showResultMessage(totalResult);
    }
}
