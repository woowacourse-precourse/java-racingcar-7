package racingcar.race;

import java.util.List;
import racingcar.car.CarFactory;
import racingcar.car.Cars;
import racingcar.io.InputHandler;
import racingcar.io.Output;

public class RaceController {
    private final InputHandler inputHandler;
    private final Race race;
    private final Cars cars;
    private final CarFactory carFactory;
    private int numOfRounds;

    public RaceController(InputHandler inputHandler, Race race, Cars cars, CarFactory carFactory) {
        this.inputHandler = inputHandler;
        this.race = race;
        this.cars = cars;
        this.carFactory = carFactory;
    }

    public void runRace() {
        setupRace();
        race.startRace(cars.getCars(), numOfRounds);
        List<String> winnerNames = cars.findWinners();
        Output.printWinners(winnerNames);
    }

    private void setupRace() {
        try {
            String[] carNames = inputHandler.inputCarNamesProcess();
            numOfRounds = inputHandler.inputNumberOfRoundProcess();
            createCars(carNames);
        } finally {
            inputHandler.closeConsole();
        }
    }

    private void createCars(String[] carNames) {
        for (String name : carNames) {
            cars.addCar(carFactory.createCar(name));
        }
    }
}
