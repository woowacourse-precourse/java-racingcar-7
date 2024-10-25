package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarFactory carFactory;

    public Race() {
        this.inputView = new InputView();
        this.carFactory = new CarFactory();
        this.outputView = new OutputView();
    }

    public void startRace() {
        List<String> carNames = inputView.getCars();
        int attemptNum = inputView.getAttemptNum();
        List<Car> cars = carFactory.createCars(carNames);

        outputView.startOutput();

        for (int i = 0; i < attemptNum; i++) {
            for (Car car : cars) {
                car.occurRandomNum();
                checkAdvance(car);
                outputView.racingProgress(car);
            }
            outputView.blankLine();
        }

        racingResult(cars);

    }

    private void checkAdvance(Car car) {
        if(car.getRandomNum() >= 4) {
            car.increaseCountAdvance();
        }
    }


    public void racingResult(List<Car> cars) {
        int maxAdvanceNum = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getCountAdvance() > maxAdvanceNum) {
                maxAdvanceNum = car.getCountAdvance();
            }
        }

        for (Car car : cars) {
            if (car.getCountAdvance() == maxAdvanceNum) {
                winners.add(car.getName());
            }
        }

        outputView.racingResult(winners);

    }


}
