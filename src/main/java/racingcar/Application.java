package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String inputNames = Console.readLine();
        String rounds = Console.readLine();

        InputValidator inputValidator = new InputValidator(inputNames, rounds);
        try {
            inputValidator.validateName();
            inputValidator.validateRounds();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

        GameController gameController = new GameController(inputNames, rounds);
        gameController.playGame();
    }
}
