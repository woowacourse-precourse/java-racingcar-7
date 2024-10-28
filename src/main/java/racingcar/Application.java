package racingcar;

import racingcar.controller.CarRacingGame;

public class Application {
    public static void main(String[] args) {
        try {
            CarRacingGame carRacingGame = new CarRacingGame();
            carRacingGame.run();
        } catch (IllegalArgumentException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
