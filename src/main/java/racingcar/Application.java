package racingcar;

import racingcar.car.controller.CarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarController carController = CarController.getInstance();
        carController.createCars();
        carController.moveCars();
        carController.getWinners();
    }
}
