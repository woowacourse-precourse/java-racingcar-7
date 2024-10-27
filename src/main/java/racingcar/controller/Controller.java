package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;
import racingcar.model.RandomGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private static final String CURRENT_LOCATION = "";
    private static final String SEPARATOR = ",";
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Car> initializeGame(String carsName) {
        List<String> eachCarName = List.of(carsName.split(SEPARATOR));
        List<Car> carList = new ArrayList<>();
        for (String name : eachCarName) {
            Car car = new Car(name, CURRENT_LOCATION);
            carList.add(car);
        }
        return carList;
    }

    public void run() {
        String carsName = inputView.inputName();
        List<Car> carList = initializeGame(carsName);

        Cars cars = new Cars(carList);
        int times = Integer.parseInt(inputView.inputTimes());
        RandomGenerator randomGenerator = new RandomGenerator();

        RacingGame racingGame = new RacingGame(cars, randomGenerator, outputView);

        racingGame.start(times);
    }

}
