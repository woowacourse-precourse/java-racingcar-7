package racingcar.controller;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.model.Register;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Register register;

    public CarRacingController(InputView inputView, OutputView outputView, Register register) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.register = register;
    }

    public ArrayList<String> divideCar(String cars) {
        ArrayList<String> carList = new ArrayList<>();
        for (String c : cars.split(",")) {
            String addCar = c.trim();
            carList.add(addCar);
        }
        return carList;
    }

    public void carMoves() {
        for (Car c : register.carList) {
            c.move();
        }
    }

    public void playRound(int count) {
        while (count > 0) {
            carMoves();
            outputView.outputCarMoves(register.carsMoveCountList());
            count--;
        }
    }

    public void race() {
        register.carListUp(divideCar(inputView.inputCar()));
        playRound(inputView.inputRound());
        outputView.outputWinner(register.racingWinner());
    }
}
