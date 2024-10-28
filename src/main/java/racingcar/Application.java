package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingController carRacing = new RacingController(new RacingView(), new RacingService());
        carRacing.applicationRun();

    }
}
