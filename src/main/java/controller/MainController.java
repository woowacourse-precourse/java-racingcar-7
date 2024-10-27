package controller;

import java.util.List;
import model.Car;

public class MainController {
    private final CarSetupController carSetupController;
    private final GameController gameController;

    public MainController(CarSetupController carSetupController, GameController gameController) {
        this.carSetupController = carSetupController;
        this.gameController = gameController;
    }

    public void run() {
        try {
            List<Car> cars = carSetupController.getCarsFromUserInput(); // 자동차들 입력받기
            int attempts = carSetupController.getAttemptCount(); // 시도횟수 입력받기
            gameController.startGame(cars, attempts); // 게임 실행하기
            gameController.announceWinners(cars); // 우승자 출력하기
        } catch (Exception e) {
            throw new IllegalArgumentException("게임이 정상적으로 실행되지 않았습니다", e);
        }
    }
}
