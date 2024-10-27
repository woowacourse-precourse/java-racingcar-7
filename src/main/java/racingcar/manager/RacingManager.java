package racingcar.manager;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.GeneralCarFactory;
import racingcar.util.StringSplitter;
import racingcar.validation.InputValidation;
import racingcar.view.RacingGameView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {

    CarFactory carFactory = GeneralCarFactory.getInstance();
    InputValidation validation = new InputValidation();
    RacingGameView view = new RacingGameView();
    private List<Car> carList;
    private int racingCount;

    public void run() {
        inputCarNames();
        inputRacingCount();
        startRacing();
        resultRacingGame();
    }

    private void inputCarNames() {
        String inputCarNames = validation.blankValidation(view.inputCarNames());
        this.carList = carFactory.createCars(StringSplitter.splitString(inputCarNames));
    }

    private void inputRacingCount() {
        this.racingCount = validation.checkCountValidation(view.inputRacingCount());
    }

    private void startRacing() {
        view.printRaceResult();
        for (int i = 1; i <= racingCount; i++) {
            moveCars();
            view.printRaceProgress(carList);
        }
    }

    private void resultRacingGame() {
        String winners = findWinners();
        view.printRaceWinner(winners);
    }

    private void moveCars() {
        for (Car car : carList) car.move();
    }

    private int findWinnerPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max().getAsInt();
    }

    private String findWinners() {
        int maxPosition = findWinnerPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
