package racingcar.Factory;

import racingcar.Controller.RaceProcessController;
import racingcar.Controller.RaceViewController;
import racingcar.Service.RaceProcessService;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class ControllerFactory {
    private final DomainFactory domainFactory;
    public ControllerFactory(DomainFactory domainFactory) {
        this.domainFactory = domainFactory;
    }

    public RaceViewController createRaceViewController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        return new RaceViewController(inputView, outputView);
    }

    public RaceProcessController createRaceProcessController(RaceViewController viewController) {
        RaceProcessService raceProcessService = new RaceProcessService(domainFactory);

        return new RaceProcessController(viewController, raceProcessService);
    }
}
