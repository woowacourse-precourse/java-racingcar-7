package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    private final OutputView outputView;
    private final InputView inputView;
    private final CarService carService;

    public CarController(OutputView outputView, InputView inputView, CarService carService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.carService = carService;
    }

    public void run() {
        outputView.printStartMessage();
        ArrayList<String> carNames = inputView.readCarNames();

        for (String carName : carNames) {
            carService.addParticipant(carName);
        }

        outputView.printAttemptMessage();
        int attempts = inputView.readAttempts();

        startGame(attempts);
        List<String> winners = carService.getWinners();
        outputView.printWinners(winners);
    }

    public void startGame(int attempts) {
        outputView.printResultMessage();

        List<Car> participants = carService.getParticipants();
        for (int i = 0; i < attempts; i++) {
            carService.advanceCars();
            outputView.printResult(participants);
        }

        carService.updateWinners();
    }
}
