package racingcar;

import controller.RacingController;
import service.CarSetService;
import service.GameService;
import service.ResultService;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultService resultService = new ResultService();
        OutputView outputView = new OutputView(resultService);
        CarSetService carSetService = new CarSetService();
        GameService gameService = new GameService(resultService);

        RacingController racingController = new RacingController(inputView, outputView, gameService, carSetService);
        racingController.start();
    }
}
