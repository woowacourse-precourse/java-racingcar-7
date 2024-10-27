package racingcar.domain;

import racingcar.car.RacingCar;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private List<RacingCar> racingCarList;
    private String maxMovedHistory;

    public RaceResult(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
        this.maxMovedHistory = racingCarList.stream()
                .max(Comparator.comparing(RacingCar::getMovedHistory))
                .map(RacingCar::getMovedHistory).orElse("");
    }

    public List<String> findWinners() {
        return racingCarList.stream()
                .filter(racingCar -> racingCar.getMovedHistory().equals(maxMovedHistory))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
