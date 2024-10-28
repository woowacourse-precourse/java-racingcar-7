package racingcar.controller;

import racingcar.domain.Car;
import racingcar.util.Conditioner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class RacingCarController {

    private Car[] cars;
    private int tryCount;
    private ArrayList<Car> winners = new ArrayList<>();

    public void setCars() {
        String carsInput = InputView.readCars();
        tryCount = Integer.parseInt(InputView.readTryCount());

        makeCars(carsInput);
    }

    public void makeCars(String carsInput) {
        String[] stringCars = carsInput.split(",");
        cars = new Car[stringCars.length];

        for (int i = 0; i < stringCars.length; i++) {
            if (stringCars[i].length() > 5) {
                throw new IllegalArgumentException();
            }
            cars[i] = new Car(stringCars[i], 0);
        }
    }

    public void run() {
        OutputView.printResultFormatPerOneRace();
        for (int i = 0; i < tryCount; i++) {
            runOneRace();
            OutputView.printResultPerOneRace(cars);
        }

        setWinners();
        OutputView.printResultFinal(winners);
    }

    public void runOneRace() {
        for (Car car : cars) {
            boolean moveOrNotMoved = Conditioner.setCondition();
            if (moveOrNotMoved) {
                car.moveForward();
            }
        }
    }

    private void setWinners() {
        int maxNum = -1;
        for (Car car : cars) {
            if (car.getPosition() > maxNum) {
                maxNum = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxNum) {
                winners.add(car);
            }
        }
    }
}
