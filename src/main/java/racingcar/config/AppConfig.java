package racingcar.config;

import racingcar.controller.CarGameController;
import racingcar.service.CarCreateService;
import racingcar.service.CarGameService;
import racingcar.view.Inputview;
import racingcar.view.OutputView;

public class AppConfig {

    private final CarGameController carGameController;
    private final CarGameService carGameService;
    private final CarCreateService carCreateService;
    private final Inputview inputView;
    private final OutputView outputView;

    public AppConfig() {
        this.inputView = new Inputview();
        this.outputView = new OutputView();
        this.carCreateService = new CarCreateService();
        this.carGameService = new CarGameService();
        this.carGameController = new CarGameController(
            carGameService,
            carCreateService,
            inputView,
            outputView);
    }

    public CarGameController getCarGameController() {
        return carGameController;
    }
}
