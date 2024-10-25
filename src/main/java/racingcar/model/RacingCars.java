package racingcar.model;

import java.util.List;

public record RacingCars(List<RacingCar> racingCarList) {

    public static RacingCars init(List<String> carNameList) {
        List<RacingCar> initRacingCarList = carNameList.stream()
                .map(RacingCar::init)
                .toList();
        return new RacingCars(initRacingCarList);
    }

    public RacingCars move() {
        List<RacingCar> movedRacingCarList = racingCarList.stream()
                .map(RacingCar::move)
                .toList();
        return new RacingCars(movedRacingCarList);
    }
}