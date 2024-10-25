package racingcar.transporter;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class BasicRacingCarTransporter implements RacingCarTransporter {
    @Override
    public void transportRacingCar(List<Car> racingCars) {
        for (Car racingCar : racingCars) {
            if (isMove()) {
                racingCar.move();
            }
        }
    }

    private boolean isMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
