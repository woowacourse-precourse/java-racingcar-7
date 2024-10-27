package racingcar;

public class GameController {

    public static void gameStart() {
        InputController inputController = new InputController();
        Validator validator = new Validator(inputController.printCarNamesInput());
        validator.validate();
        RacingGame racingGame = new RacingGame(validator.separateCarNames(), inputController.printTryTimesInput());
        WinnerValidator winnerValidator = new WinnerValidator(racingGame.getCarNumber());
        winnerValidator.outputWinners(winnerValidator.findRacingWinners());
    }
}
