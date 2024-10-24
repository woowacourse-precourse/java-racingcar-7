package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.presentation.CarPositionsDisplay;

public class GameRound {
    private final CarPositionsDisplay carPositionsDisplay;
    private final MovingStrategy movingStrategy;

    public GameRound() {
        this.movingStrategy = new RandomMovingStrategy();
        this.carPositionsDisplay = new CarPositionsDisplay();
    }

    public Cars getCars(String carNames){
        List<Car> carList = Arrays.stream(carNames.split(","))
                .map(each -> new Car(each, movingStrategy))
                .toList();
        return new Cars(carList);
    }

    // 값 객체를 사용할까?
    public String runRace(Cars cars, int trialCount) {
        StringBuilder raceResult = new StringBuilder();

        for (int i = 0; i < trialCount; i++) {
            cars.moveAll();
            String currentPositions = carPositionsDisplay.formatPositions(cars);
            raceResult.append(currentPositions).append("\n");
        }

        List<String> champions = cars.getWinnerNames();
        String winnerNamesFormatted = carPositionsDisplay.formatWinnerNames(champions);

        raceResult.append(winnerNamesFormatted);

        return raceResult.toString();
    }
}
