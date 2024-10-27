package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars() {
        this.racingCars = new ArrayList<>();
    }

    public RacingCars(List<RacingCar> racingCars) {
        if (racingCars == null) {
            throw new IllegalArgumentException("자동차 리스트는 null 일 수 없습니다.");
        }
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

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public int findWinnerPosition() {
        return racingCars.stream()
                .max(Comparator.comparingInt(RacingCar::getPosition))
                .orElseThrow(RuntimeException::new)
                .getPosition();
    }
}
