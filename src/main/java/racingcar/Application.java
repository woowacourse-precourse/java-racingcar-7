package racingcar;

public class Application {
    public static void main(String[] args) {
        InputAmountOfRace inputAmount = new InputAmountOfRace();
        inputAmount.inputRaceAmount();
        int raceAmount = inputAmount.getRaceAmount();

        RandomRaceOrNot raceResult = new RandomRaceOrNot();
        raceResult.performRace();

        OutputRacing outputRacing = new OutputRacing();
        outputRacing.main(args);
    }
}
