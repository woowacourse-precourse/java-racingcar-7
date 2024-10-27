package racingcar;

import java.util.List;

public class CarRacing {
    private int attempts = 0;

    public void init() {
        List<Car> cars;

        cars = ready();
        start(cars, attempts);
        finish(cars);
    }

    private List<Car> ready() {
        List<Car> cars;
        final ReadyToRace readyToRace = new ReadyToRace();

        // inputStringsArr = [ 자동차 이름들, 시도횟수 ]
        final List<String> inputStringsArr = readyToRace.inputStrings();

        attempts = ReadyToRace.convertAttempts(inputStringsArr.get(1));
        cars = readyToRace.createCarObjects(ReadyToRace.convertCarNames(inputStringsArr.get(0)));

        return cars;
    }

    private void start(final List<Car> cars, final int attempts) {
        StartRace startRace = new StartRace();
        startRace.racingStart(cars, attempts);
    }

    private void finish(List<Car> cars) {
        final FinishRace finishRace = new FinishRace();
        List<String> winnerNames = finishRace.determineWinner(cars);
        finishRace.printGameWinners(winnerNames);
    }
}