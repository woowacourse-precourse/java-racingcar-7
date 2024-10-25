package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;

public class RaceResult {

    private final Race race;

    public RaceResult(Race race) {
        this.race = race;
    }

    public List<Car> getRaceWinnerList() {
        List<Car> raceResult = race.getSortedRaceResults();
        Car winnerCar = raceResult.get(0);

        List<Car> winners = new ArrayList<>();
        for (Car car : raceResult) {
            if (car.getRacingDistance() == winnerCar.getRacingDistance()) {
                winners.add(car);
            } else {
                break;
            }
        }
        return winners;
    }
}
