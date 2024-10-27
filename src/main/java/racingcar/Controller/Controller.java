package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Domain.Car;
import racingcar.View.InputView;

public class Controller {
    private InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public Car run() {
        inputView.carnameInput();
        String input = Console.readLine();
        return new Car(input);
    }
}
