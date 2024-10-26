package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Domain.Car;
import racingcar.View.CarNameView;

public class Controller {
    private CarNameView carNameView;

    public Controller(CarNameView carNameView) {
        this.carNameView = carNameView;
    }

    public Car run() {
        carNameView.carnameInput();
        String input = Console.readLine();
        return new Car(input);
    }
}
