package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RaceCountValidator;
import racingcar.view.OutputView;

public class RaceGame {


    private final Move move;

    public RaceGame(Move move) {
        this.move = move;

    }

    public String playGame(List<Car> racingCars, String  raceCountInput) {
        int raceCount = parseRaceCount(raceCountInput);
        List<Car> gameResult = printRaceResult(racingCars, raceCount);

        return compareWinner(gameResult);

    }

    private static int parseRaceCount(String raceCount) {
        RaceCountValidator.validate(raceCount);
        return Integer.parseInt(raceCount);
    }

    private List<Car> printRaceResult(List<Car> cars, int raceCount) {

        for (int i = 0; i < raceCount; i++) {
            move.moveAccordingToRandomNumber(cars);
            OutputView.printRaceProgress(cars);
            System.out.println();
        }

        return cars;
    }

    private String compareWinner(List<Car> gameResult) {

        int maxValue = move.getMaxMoveCount(gameResult);

        return gameResult.stream()
                .filter(car -> maxValue == car.getMoveCount())
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

    }
}
