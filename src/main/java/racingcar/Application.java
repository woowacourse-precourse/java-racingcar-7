package racingcar;

import racingcar.Controller.CarController;

public class Application {
    public static void main(String[] args) {

        CarController carController = new CarController();

        carController.raceStart();
    }
}
