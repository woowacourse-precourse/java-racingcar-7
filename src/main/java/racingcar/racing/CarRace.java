package racingcar.racing;

import static racingcar.common.RacingCarConstant.MAX_RANDOM_BOUND;
import static racingcar.common.RacingCarConstant.MIN_RANDOM_BOUND;
import static racingcar.common.RacingCarConstant.MOVE_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarRace implements Race<RacingCar> {

    @Override
    public void start(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            if (isMovable()) {
                racingCar.forward();
            }
        });
    }

    private boolean isMovable() {
        int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND);
        return randomValue >= MOVE_THRESHOLD;
    }
}
