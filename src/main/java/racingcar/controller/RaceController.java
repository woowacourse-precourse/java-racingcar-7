package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.dto.CarDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Race;
import racingcar.utils.MoveDecider;
import racingcar.utils.RandomNumberGenerator;
import racingcar.utils.validator.CarNameValidator;
import racingcar.utils.validator.TryNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Race race;
    private final Cars cars;

    public RaceController(InputView inputView, OutputView outputView, Cars cars) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = cars;
        this.race = new Race(cars, new MoveDecider(new RandomNumberGenerator()));
    }

    public void run() {
        registerCars();
        startRace();
        presentResult();
    }

    private void registerCars() {
        String[] inputCarNames = inputView.inputRacingCarNames().split(",");
        List<String> carList = Arrays.asList(inputCarNames);
        CarNameValidator.validateCarNameIsCorrect(carList);
        cars.addCars(carList);
    }

    private void startRace() {
        int rounds = getRound();
        outputView.printRunResultMessage();
        printRoundStatus(rounds);
    }

    private void presentResult() {
        race.determineFinalWinner();
        outputView.printFinalWinner(race.getFinalWinners());
    }

    private void printRoundStatus(final int rounds) {
        for (int round = 0; round < rounds; round++) {
            List<Car> roundStatus = race.startRound();
            roundStatus.forEach(car -> outputView.printCarMoveDistance(toDto(car)));
            outputView.lineAlignment();
        }
    }

    private int getRound() {
        String inputRound = inputView.inputAttemptCount();
        TryNumberValidator.validateTryNumberIsCorrect(inputRound);

        return Integer.parseInt(inputRound);
    }

    private CarDto toDto(Car car) {
        return new CarDto(car.getName(), car.getDistance());
    }
}
