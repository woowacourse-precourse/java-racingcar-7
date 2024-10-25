package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomRaceController {

    private boolean isAdvance() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

    public List<RacingCar> start(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            if (isAdvance()) {
                racingCar.race();
            }
        }
        return racingCars;
    }

}
