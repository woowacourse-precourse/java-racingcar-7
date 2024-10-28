package racingcar.controller;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.utils.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    public void run() {
        Cars cars = getCars();
        AttemptNumber attemptNumber = getAttemptNumber();
        race(cars, attemptNumber);
        printWinners(cars);
    }

    private Cars getCars() {
        List<String> carNames = InputView.readCarNames();
        return Cars.from(carNames);
    }

    private AttemptNumber getAttemptNumber() {
        int attemptnumber = InputView.readAttemptNumber();
        return new AttemptNumber(attemptnumber);
    }

    private void race(Cars cars, AttemptNumber attemptNumber) {
        OutputView.printResult();
        RandomNumber randomNumber = new RandomNumber();

        while (attemptNumber.isRemain()) {
            attemptNumber.decrease();
            cars.moveAll(randomNumber);
            printRaceStatus(cars);
        }
    }

    private void printRaceStatus(Cars cars) {
        List<CarDto> carDtos = CarDto.getInstances(cars);
        OutputView.printStatus(carDtos);
    }

    private void printWinners(Cars cars) {
        Cars winnerCars = cars.findWinners();
        List<CarDto> winnerCarDtos = CarDto.getInstances(winnerCars);
        OutputView.printWinners(winnerCarDtos);
    }

}
