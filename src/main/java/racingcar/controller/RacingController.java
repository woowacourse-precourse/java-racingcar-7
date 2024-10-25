package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Racing;
import racingcar.utils.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private Racing racing;
    private Cars cars;
    private StringSplitter stringSplitter;
    private OutputView outputView;

    public RacingController(Racing racing, Cars cars, StringSplitter stringSplitter,
            OutputView outputView) {
        this.racing = racing;
        this.cars = cars;
        this.stringSplitter = stringSplitter;
        this.outputView = outputView;
    }

    public void start() {
        initCars();
        executeRaceRounds();
        announceWinner();
    }

    private void initCars() {
        String inputCarString = InputView.getInputCarString();
        List<String> strings = stringSplitter.splitByDelimiter(inputCarString);
        for (String s : strings) {
            Car car = new Car(s);
            cars.addCar(car);
        }
    }

    private void executeRaceRounds() {
        int cnt = Integer.parseInt(InputView.getInputRepeatCount());
        outputView.printGameResultMessage();
        for (int i = 0; i < cnt; i++) {
            runSingleRound();
            outputView.printEmptyLine();
        }
    }

    private void announceWinner() {
        String winner = racing.findWinner(cars.getCars());
        outputView.printWinner(winner);
    }

    private void runSingleRound() {
        List<Car> cars = racing.startRacing();
        for (Car car : cars) {
            outputView.printGameResult(car.getName(), car.getMovedDistance());
        }
    }

}
