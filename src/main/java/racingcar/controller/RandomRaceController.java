package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.RacingCar;
import racingcar.view.RaceProgressView;

public class RandomRaceController {
    private final RaceProgressView raceProgressView;

    public RandomRaceController() {
        this.raceProgressView = new RaceProgressView();
    }

    private boolean isAdvance() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

    public List<RacingCar> start(List<RacingCar> racingCars, Long tryNums) {
        for (int i = 0; i < tryNums; i++) {
            startRaceForEachCar(racingCars);
            raceProgressView.displayRoundProgress(racingCars);
        }
        return racingCars;
    }

    private void startRaceForEachCar(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            if (isAdvance()) {
                racingCar.race();
            }
        }
    }

}
