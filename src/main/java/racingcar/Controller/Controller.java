package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Domain.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class Controller {
    private InputView inputView;
    private OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Car run() {
        inputView.carnameInput();
        String input = Console.readLine();
        return new Car(input);
    }
}
