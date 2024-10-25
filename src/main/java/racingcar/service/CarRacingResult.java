package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.context.Car;

public class CarRacingResult {
    private Integer carRacingWinnerDistance;
    private List<String> carRacingWinners;

    public CarRacingResult(List<Car> carGroup) {
        this.carRacingWinnerDistance = getCarRacingWinnerDistance(carGroup);
        this.carRacingWinners = getCarRacingWinner(carGroup);
    }

    private Integer getCarRacingWinnerDistance(List<Car> carGroup) {
        Integer carRacingWinnerRecord = 0;
        for (Car car : carGroup) {
            if (carRacingWinnerRecord < car.getCarMovementDistance()) {
                carRacingWinnerRecord = car.getCarMovementDistance();
            } //메서드 분리 필요
        }
        return carRacingWinnerRecord;
    }

    private List<String> getCarRacingWinner(List<Car> carGroup) {
        List<String> carRacingWinnerName = new ArrayList<>();
        for (Car car : carGroup) {
            if (car.getCarMovementDistance().equals(carRacingWinnerDistance)) {
                carRacingWinnerName.add(car.getCarName());
            } //메서드 분리 필요
        }
        return carRacingWinnerName;
    }

    public List<String> getCarRacingWinners() {
        return carRacingWinners;
    }
}
