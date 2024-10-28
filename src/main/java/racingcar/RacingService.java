package racingcar;

public class RacingService {
    public void start(ConsoleInput consoleInput) {
        // todo: input validate
        CarCollectionFactory carCollectionFactory = new CarCollectionFactory(new SimpleDelimiterProcessor(), new RandomCarFactory());
        carCollectionFactory.create(consoleInput.carNames());
    }
}
