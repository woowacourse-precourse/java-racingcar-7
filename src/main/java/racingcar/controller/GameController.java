package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.validation.InputValidator;
import racingcar.view.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    private final ConsoleView view;

    public GameController(ConsoleView view) {
        this.view = view;
    }

    public void startGame() {
        List<Car> cars = initializeCars();
        Race race = new Race(cars);
        int movements = getMovements();

        runRace(race, cars, movements);
        announceWinners(race);
    }

    private List<Car> initializeCars() {
        String carNames = view.readCarNamesInput();
        validateCarNames(carNames);
        return createCars(Arrays.asList(carNames.split(",")));
    }

    private void validateCarNames(String carNames) {
        InputValidator.validateCarNamesSeparator(carNames);
        InputValidator.validateInputFormat(carNames);
    }

    private List<Car> createCars(List<String> carNameList) {
        InputValidator.validateDuplicateCarNames(carNameList);
        List<Car> cars = new ArrayList<>();

        for (String name : carNameList) {
            InputValidator.validateCarName(name);
            cars.add(new Car(name));
        }
        return cars;
    }

    private int getMovements() {
        String movementInput = view.readMovementInput();
        InputValidator.validateMovementString(movementInput);
        InputValidator.validateMovement(movementInput);
        return Integer.parseInt(movementInput);
    }

    private void runRace(Race race, List<Car> cars, int movements) {
        view.printGameStartMessage();
        for (int i = 0; i < movements; i++) {
            race.run(1);
            view.printRaceStatus(cars);
        }
    }

    private void announceWinners(Race race) {
        List<String> winners = race.getWinners();
        view.printWinners(winners);
    }
}
