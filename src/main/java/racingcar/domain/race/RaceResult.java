package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class RaceResult {

    private final List<Race> races;

    public RaceResult(List<Race> races) {
        this.races = races;
    }

    public List<Car> getRaceWinnerList() {
        List<Car> finalRaceSortedResult = getFinalRaceSortedResult();
        return getCoWinnerCarList(finalRaceSortedResult);
    }

    public List<Race> getRaces() {
        return races;
    }

    private List<Car> getFinalRaceSortedResult() {
        return new ArrayList<>(races.getLast().getSortedRaceResults());
    }

    private List<Car> getCoWinnerCarList(List<Car> sortedRaceResults) {
        long winningDistance = sortedRaceResults.getFirst().getRacingDistance();
        List<Car> winners = new ArrayList<>();

        for (Car car : sortedRaceResults) {
            if (car.getRacingDistance() == winningDistance) {
                winners.add(car);
            } else {
                break;
            }
        }
        return winners;
    }
}
