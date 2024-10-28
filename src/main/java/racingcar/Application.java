package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        (new RacingController(
            new InputView(),
            new OutputView(),
            new RacingService(
                    new CarCollectionFactory(
                            new SimpleDelimiterProcessor(),
                            new RandomCarFactory()
                    )
            )
        )).run();


    }
}
