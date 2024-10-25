package racingcar;

public class RacingGame {

    private final CarManager carManager;
    private final int tryNumber;
    private static final String START_MESSAGE = "실행 결과";

    public RacingGame(CarManager carManager, int tryNumber) {
        this.carManager = carManager;
        this.tryNumber = tryNumber;
    }

    public void play() {

        Writer.writeMessage(START_MESSAGE);

        for (int i = 0; i < tryNumber; i++) {
            carManager.playRound();
            Writer.writeRoundResult(carManager.getCars());
        }

        Writer.writeWinner(carManager.getWinners());
    }
}
