package racingcar.model;

import java.util.List;

public class CarRacing {

    private List<RacingCar> racingCars;
    private int moveForwardTryCount;

    public CarRacing(List<RacingCar> racingCars, int moveForwardTryCount) {
        this.racingCars = racingCars;
        this.moveForwardTryCount = moveForwardTryCount;
    }

    public void tryMoveForward() {
        racingCars.forEach(RacingCar::tryMoveForward);
        moveForwardTryCount--;
    }

    public List<RacingCar> getRaceWinners() {
        int maxDistanceCovered = racingCars.stream()
                .mapToInt(RacingCar::getDistanceCovered)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(car -> car.getDistanceCovered() == maxDistanceCovered)
                .toList();
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public int getMoveForwardTryCount() {
        return moveForwardTryCount;
    }
}
