package racingcar;

public class RacingService {
    private static final String NULL_INPUT = "입력이 null입니다.";

    private CarCollectionFactory carCollectionFactory;

    public RacingService(CarCollectionFactory carCollectionFactory) {
        this.carCollectionFactory = carCollectionFactory;
    }

    public void start(ConsoleInput consoleInput, OutputView outputView) {
        outputView.printInfo();

        CarCollection carCollection = carCollectionFactory.create(consoleInput.carNames());
        validateTryCount(consoleInput.tryCount());
        int round = Integer.parseInt(consoleInput.tryCount());
        for (int i = 0; i < round; i++) {
            carCollection.move();
            outputView.printRound(carCollection.getCars());
        }
        outputView.printWinner(carCollection.getWinners());
    }

    private void validateTryCount(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_INPUT);
        }
    }
}
