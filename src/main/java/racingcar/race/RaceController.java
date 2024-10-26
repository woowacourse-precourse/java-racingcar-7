package racingcar.race;

import java.util.List;
import racingcar.car.CarFactory;
import racingcar.car.Cars;
import racingcar.io.InputHandler;
import racingcar.io.Output;

public class RaceController {
    private final InputHandler inputHandler;
    private final CarFactory carFactory;
    private final Race race;
    private final Cars cars;
    private int numOfRounds;

    public RaceController(InputHandler inputHandler, CarFactory carFactory) {
        this.inputHandler = inputHandler;
        this.carFactory = carFactory;
        this.race = new Race(); // TODO
        this.cars = new Cars();
    }

    public void runRace() {
        setupRace();
        race.startRace(cars.getCars(), numOfRounds);
        List<String> winnerNames = cars.findWinners();
        Output.printWinners(winnerNames);
    }

    private void setupRace() {
        String[] carNames = inputHandler.processCarNamesInput();
        numOfRounds = inputHandler.processNumberOfRoundInput();
        createCars(carNames);
    }

    private void createCars(String[] carNames) {
        for (String name : carNames) {
            cars.addCar(carFactory.createCar(name));
        }
    }
}
