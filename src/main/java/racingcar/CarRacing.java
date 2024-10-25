package racingcar;

import java.util.ArrayList;

public class CarRacing {
    private int attempts = 0;

    public void init() {
        ArrayList<Car> cars;

        cars = ready();
        start(cars, attempts);
        finish(cars);
    }

    private ArrayList<Car> ready() {
        ArrayList<Car> cars;
        final ReadyToRace readyToRace = new ReadyToRace();

        // inputStringsArr = [ 자동차 이름들, 시도횟수 ]
        final ArrayList<String> inputStringsArr = readyToRace.inputStrings();

        attempts = ReadyToRace.convertAttempts(inputStringsArr.get(1));
        cars = readyToRace.createCarObjects(ReadyToRace.convertCarNames(inputStringsArr.get(0)));

        return cars;
    }

    private void start(final ArrayList<Car> cars, final int attempts) {
        StartRace startRace = new StartRace();
        ArrayList<Car> winnerCars = startRace.racingStart(cars, attempts);
    }

    private void finish(ArrayList<Car> cars) {
        final FinishRace finishRace = new FinishRace();
        ArrayList<String> winnerNames = finishRace.determineWinner(cars);
        finishRace.printGameWinners(winnerNames);
    }
}