package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService service;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        List<String> nameList = inputView.readNameList();
        List<Car> cars = service.parseNameList(nameList);
        int count = inputView.readCount();

        outputView.printMidTitle();
        for (int i = 0; i < count; i++) {
            service.moveCarRandomly(cars);
            outputView.printMidResult(cars);
        }
        outputView.printFinalResult(cars);
    }
}
