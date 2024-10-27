package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingIO.promptCarNamesInput();
        String carNameInput = RacingIO.getInput();

        RacingIO.promptMoveCountInput();
        String moveCountInput = RacingIO.getInput();

        RacingService racingService = new RacingService(carNameInput, moveCountInput);

        racingService.startRaceGame();
        RacingIO.promptTurnResult(racingService.getTurnResult());
        RacingIO.promptWinner(racingService.getWinners());
    }
}
