package racingcar;


import racingcar.controller.MainController;
import racingcar.domain.CarFactory;
import racingcar.service.WinnerDeterminer;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Validator validator = new Validator();
        CarFactory carFactory = new CarFactory();
        WinnerDeterminer winnerDeterminer = new WinnerDeterminer();

        MainController controller = new MainController(inputView, outputView, validator, carFactory, winnerDeterminer);
        controller.startRace();
    }
}
