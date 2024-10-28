package racingcar;

public class Application {
    public static void main(String[] args) {
        InputCarName carNameInput = new InputCarName();
        String[] carList = carNameInput.getCarList();

        InputAmountOfRace inputAmount = new InputAmountOfRace();
        inputAmount.inputRaceAmount();
        int raceAmount = inputAmount.getRaceAmount();

        RandomRaceOrNot raceResult = new RandomRaceOrNot();
        raceResult.performRace(carList, raceAmount);

        OutputRacing outputRacing = new OutputRacing();
        outputRacing.printFinalResults(raceResult);
    }
}
