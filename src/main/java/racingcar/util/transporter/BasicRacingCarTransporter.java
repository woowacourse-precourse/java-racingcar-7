package racingcar.util.transporter;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.RacingCar;

public class BasicRacingCarTransporter implements RacingCarTransporter {
    @Override
    public void transportRacingCar(List<RacingCar> racingCars, List<Integer> randomNumbers) {
        for (int i = 0; i < racingCars.size(); i++) {
            if (isMove(randomNumbers.get(i))) {
                racingCars.get(i).move();
            }
        }
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }
}
