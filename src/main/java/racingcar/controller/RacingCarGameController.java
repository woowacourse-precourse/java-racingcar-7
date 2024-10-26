package racingcar.controller;

import racingcar.dto.CarNameDto;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.StringSplitter;

import java.util.List;

public class RacingCarGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final StringSplitter stringSplitter = new StringSplitter();

    public void start() {
        String inputCarNames = inputView.getCarNames();

        List<String> carNamesList = stringSplitter.splitCarNamesToSeparator(inputCarNames);
        Cars cars = new Cars(carNamesList);

        Referee referee = new Referee(inputView.getNumberOfRound());

        outputView.printNewline();
        outputView.printResultMessage();

        carsMovementProgress(referee, cars);

        printWinningCars(cars, referee);
    }

    private void printWinningCars(Cars cars, Referee referee) {
        List<Car> winnerCarsList = referee.judgementWinnerCars(cars);
        List<CarNameDto> winnerCarNames = convertToCarNameDtos(winnerCarsList);
        outputView.printWinners(winnerCarNames);
    }

    private List<CarNameDto> convertToCarNameDtos(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .map(CarNameDto::of)
                .toList();
    }

    private void carsMovementProgress(Referee referee, Cars cars) {
        for (int i = 0; i < referee.getRoundNumber(); i++) {
            cars.carsMovement(cars.getCars());
            outputView.printAllCarMovement(cars.getCars());
            outputView.printNewline();
        }
    }
}
