package controller;

import racingcar.Car;
import view.InputView;
import view.OutputView;

public class RaceController {
    public void start() {
        Car car = new Car();
        setCars(car);
        setTryNumber(car);
    }

    public void setCars(Car car) {
        try {
            car.addCar(InputView.printSetCarMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            setCars(car);
        }
    }

    public void setTryNumber(Car car) {
        try {
            car.setTryNumber(InputView.printGetTryNumberMessage()); // setTryNumber 사용 가능
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            setTryNumber(car);
        }
    }
}
