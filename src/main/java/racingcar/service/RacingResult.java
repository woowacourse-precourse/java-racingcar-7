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
        for (RacingCar car : racingCars) {
            if (carRacingWinnerRecord < car.getCarMovementDistance()) {
                carRacingWinnerRecord = car.getCarMovementDistance();
            } //메서드 분리 필요
        }
        return carRacingWinnerRecord;
    }

    private List<String> getCarRacingWinner(List<RacingCar> racingCars) {
        List<String> carRacingWinnerNames = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (car.getCarMovementDistance().equals(carRacingWinnerDistance)) {
                carRacingWinnerNames.add(car.getCarName());
            } //메서드 분리 필요
        }
        return carRacingWinnerNames;
    }

    public List<String> getCarRacingWinners() {
        return carRacingWinners;
    }
}
