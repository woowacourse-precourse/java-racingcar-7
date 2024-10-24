package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.CarRace;

public class CarRaceService {

    private CarRace carRace;

    public void init(String carNames) {
        carRace = new CarRace(carNames);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
