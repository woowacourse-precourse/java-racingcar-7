package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Register;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Register register = new Register();

    public void run() {
        register.carListUp(divide(inputView.inputCar()));
        int count = inputView.inputRound();

        while (count > 0) {

            for (Car c : register.carList) {
                c.move();
            }

            outputView.outputCarMoves(register.carsMoveCount());

            count--;
        }

        outputView.outputWinner(register.racingWinner());
    }

    public ArrayList<String> divide(String cars) {
        return new ArrayList<>(List.of(cars.split(",")));
    }
}
