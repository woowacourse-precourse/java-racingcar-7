package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.context.RacingCar;

public class RacingResult {
    private Integer carRacingWinnerDistance;
    private List<String> carRacingWinners;

    public RacingResult(List<RacingCar> racingCars) {
        this.carRacingWinnerDistance = getCarRacingWinnerDistance(racingCars);
        this.carRacingWinners = getCarRacingWinner(racingCars);
    }

    private Integer getCarRacingWinnerDistance(List<RacingCar> racingCars) {
        Integer carRacingWinnerRecord = 0;
        for (RacingCar racingCar : racingCars) {
            if (carRacingWinnerRecord < racingCar.getCarMovementDistance()) {
                carRacingWinnerRecord = racingCar.getCarMovementDistance();
            } //메서드 분리 필요
        }
        return carRacingWinnerRecord;
    }

    private List<String> getCarRacingWinner(List<RacingCar> racingCars) {
        List<String> carRacingWinnerNames = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            if (racingCar.getCarMovementDistance().equals(carRacingWinnerDistance)) {
                carRacingWinnerNames.add(racingCar.getCarName());
            } //메서드 분리 필요
        }
        return carRacingWinnerNames;
    }

    public List<String> getCarRacingWinners() {
        return carRacingWinners;
    }
}
