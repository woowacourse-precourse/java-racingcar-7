package racingcar;

public class Application {
    public static void main(String[] args) {
        new Application().runGame();
    }

    private void runGame() {
        String carNameInput = getCarName();
        String maxTurnInput = getMaxTurn();

        RacingService racingService = new RacingService(carNameInput, maxTurnInput);

        racingService.startRace();
        RacingIO.printRaceResult(racingService.getRaceResult());
        RacingIO.promptWinner(racingService.getWinners());
    }

    private String getCarName() {
        RacingIO.promptCarNameInput();
        return RacingIO.getInput();
    }

    private String getMaxTurn() {
        RacingIO.promptMaxTurnInput();
        return RacingIO.getInput();
    }
}
