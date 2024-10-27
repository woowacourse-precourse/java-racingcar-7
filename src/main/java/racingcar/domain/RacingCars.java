package racingcar.domain;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void addRacingCar(RacingCar racingCar) {
        checkDuplication(racingCar);
        this.racingCars.add(racingCar);
    }

    private void checkDuplication(RacingCar racingCar) {
        String newRacingCarName = racingCar.getName();

        for (RacingCar existingRacingCar : racingCars) {
            String existingRacingCarName = existingRacingCar.getName();
            if (existingRacingCarName.equals(newRacingCarName)) {
                throw new IllegalArgumentException("중복된 자동차 이름은 사용할 수 없습니다.");
            }
        }
    }

}
