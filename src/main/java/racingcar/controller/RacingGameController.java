package racingcar.controller;

import java.util.List;
import racingcar.message.Message;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private InputView inputView;
    private OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = Cars.setCars(inputView.enterCarNames());
        int count = inputView.enterCount();

        doRacing(cars, count);

        List<String> winner = cars.getWinner();
        outputView.printWinner(winner);
    }


    public void doRacing(Cars cars, int count) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(Message.result.getMessage());

        System.out.println(stringBuilder);

        while (count > 0) {
            cars.moveCars();
            outputView.printResult(cars);
            count--;
        }

    }


}
