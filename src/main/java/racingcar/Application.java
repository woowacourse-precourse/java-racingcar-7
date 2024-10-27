package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputManager inputManager = new InputManager();
        GameManager gameManager = new GameManager();

        String[] car_list = inputManager.GetCarList();
        int try_count = inputManager.GetTryCount();

        inputManager.PrintResult(
                gameManager.StartGame(car_list, try_count));

    }
}
