package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {
    private List<Car> carList;
    private int round;

    Race(List<Car> carList, int round) {
        this.carList = carList;
        this.round = round;
    }

    private void executeRound() {
        for (Car car : carList) {
            int dice = Randoms.pickNumberInRange(0, 9);
            if (dice >= 4) {
                car.forward();
            }
        }
    }

}
