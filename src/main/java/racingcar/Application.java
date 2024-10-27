package racingcar;

public class Application {
    public static void main(String[] args) {
        String carName = InputView.readCarName();
        String roundInput = InputView.readRoundCount();

        RaceManager raceManager = new RaceManager();
        raceManager.raceStart(CarNameParser.parse(carName), RoundInputParser.parse(roundInput));
    }
}
