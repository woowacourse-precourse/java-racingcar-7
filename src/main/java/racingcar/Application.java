package racingcar;

public class Application {
    public static void main(String[] args) {
        var racingCarTrace = new RacingCarTrace();
        Prompt.input(racingCarTrace);
        var tryCount = Prompt.racingTryCount();
        var biggestDistanceRacingCar = CarRacing.start(racingCarTrace, tryCount);
        Prompt.resultPrint(biggestDistanceRacingCar);
    }
}