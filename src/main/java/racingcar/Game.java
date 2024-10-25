package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {
    List<RacingCar> racingCars;

    public void init(List<String> carNames) {
        initCars(carNames);
    }

    public void initCars(List<String> carNames) {
        for (String name : carNames) {
            racingCars.add(RacingCar.createRacingCar(name));
        }
    }

    public Integer randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public Boolean isForward() {
        return randomNumber() >= 4;
    }
}
