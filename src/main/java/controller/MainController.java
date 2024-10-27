package controller;

import java.util.List;
import model.Car;

public class MainController {
    private final CarController carController;
    private final GameController gameController;

    public MainController(CarController carController, GameController gameController) {
        this.carController = carController;
        this.gameController = gameController;
    }

    public void run() {
        List<Car> cars = carController.getCarsFromUserInput(); // 자동차들 입력받기
        int attempts = carController.getAttemptCount(); // 시도횟수 입력받기
        gameController.startGame(cars, attempts); // 게임 실행하기
        gameController.announceWinners(cars); // 우승자 출력하기
    }
}