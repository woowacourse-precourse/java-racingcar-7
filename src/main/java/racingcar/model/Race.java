package racingcar.model;

import java.util.HashMap;
import java.util.List;

public class Race {
    protected List<RacingCar> racingCarList;

    public Race(List<String> racingCarsName) {
        this.racingCarList = racingCarsName.stream()
                .map(RacingCar::new).toList();
    }

    public HashMap<String, Integer> retrieveRaceResults() {
        executeRace();
        HashMap<String, Integer> executedResult = new HashMap<>();
        racingCarList.forEach(racingCar ->
                executedResult.put(racingCar.getName(), racingCar.getMoveCount()));
        return executedResult;
    }

    private void executeRace() {
        racingCarList.forEach(RacingCar::move);
    }

    public List<String> findWinners() {
        Integer winnerMoveCount = racingCarList.stream().mapToInt(RacingCar::getMoveCount).max().orElse(0);
        List<RacingCar> winners = racingCarList.stream().filter(car -> car.getMoveCount().equals(winnerMoveCount))
                .toList();
        return winners.stream().map(RacingCar::getName).toList();
    }
}
