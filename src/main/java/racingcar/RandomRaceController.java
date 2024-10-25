package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomRaceController {
    private final RaceProgressView raceProgressView;

    public RandomRaceController(RaceProgressView raceProgressView) {
        this.raceProgressView = raceProgressView;
    }

    private boolean isAdvance() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

    public List<RacingCar> start(List<RacingCar> racingCars, Long tryNums) {
        for (int i = 0; i < tryNums; i++) {
            for (RacingCar racingCar : racingCars) {
                if (isAdvance()) {
                    racingCar.race();
                }
            }
            raceProgressView.displayRoundProgress(racingCars);
        }
        return racingCars;
    }

}
