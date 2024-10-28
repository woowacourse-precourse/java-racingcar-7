package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<RacingCar> racingCarList;

    public RacingCars() {
        this.racingCarList = new ArrayList<>();
    }

    public boolean registRacingCar(RacingCar racingCar) {
        validateDuplicateCarName(racingCar);
        return racingCarList.add(racingCar);
    }

    private void validateDuplicateCarName(RacingCar racingCar) {
        if (racingCarList.contains(racingCar)) {
            throw new IllegalArgumentException("중복된 자동차 이름은 입력할 수 없습니다.");
        }
    }

}
