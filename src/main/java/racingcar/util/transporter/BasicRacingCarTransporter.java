package racingcar.util.transporter;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.RacingCar;

public class BasicRacingCarTransporter implements RacingCarTransporter {
    @Override
    public void transportRacingCar(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            if (isMove()) {
                racingCar.move();
            }
        }
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
