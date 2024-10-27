package racingcar;

public class GameController {

    public static void gameStart() {
        InputController inputController = new InputController();
        CarNameValidator carNameValidator = new CarNameValidator(inputController);
        RacingGame racingGame = new RacingGame(carNameValidator);
        WinnerValidator winnerValidator = new WinnerValidator(racingGame);
        winnerValidator.outputWinners(winnerValidator.findRacingWinners());
    }
}
