package racingcar;

import racingcar.controller.GameController;
public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.runGame();
        } catch (IllegalArgumentException e) {
            System.out.println("게임 실행 중 오류 발생: " + e.getMessage());
        }
    }
}
