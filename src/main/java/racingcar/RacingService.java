package racingcar;

public class RacingService {

    private CarCollectionFactory carCollectionFactory;

    public RacingService(CarCollectionFactory carCollectionFactory) {
        this.carCollectionFactory = carCollectionFactory;
    }

    public void start(ConsoleInput consoleInput, OutputView outputView) {
        outputView.printInfo();

        // todo: input validate
        CarCollection carCollection = carCollectionFactory.create(consoleInput.carNames());
        // todo: 캐스팅 다른곳에서 하도록
        int round = Integer.parseInt(consoleInput.tryCount());
        for (int i = 0; i < round; i++) {
            carCollection.move();
            outputView.printRound(carCollection.getCars());
        }
        outputView.printWinner(carCollection.getWinners());
    }
}
