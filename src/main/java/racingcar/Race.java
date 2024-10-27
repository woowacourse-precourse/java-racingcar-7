package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {
    private static final int DICE_START_NUMBER = 0;
    private static final int DICE_END_NUMBER = 9;
    private static final int FORWARD_CONDITION = 4;

    private List<Car> carList;
    private int round;

    Race(List<Car> carList, int round) {
        this.carList = carList;
        this.round = round;
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            executeRound();
        }
    }

    private void executeRound() {
        for (Car car : carList) {
            int dice = Randoms.pickNumberInRange(DICE_START_NUMBER, DICE_END_NUMBER);
            if (dice >= FORWARD_CONDITION) {
                car.forward();
            }
        }
    }

}
