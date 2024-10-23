package racingcar;

public class Application {
    public static void main(String[] args) {
        var racingCarTrace = new RacingCarTrace();
        Prompt.input(racingCarTrace);
        var biggestDistanceRacingCar = CarRacing.start(racingCarTrace);
        Prompt.resultPrint(biggestDistanceRacingCar);
    }
}