package racingcar;

import racingcar.manager.GameManager;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.gameStart();
    }
}
