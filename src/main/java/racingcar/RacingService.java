package racingcar;

import java.util.ArrayList;
import racingcar.car.Car;

public class RacingService {
    private static final int START_INT = 0;
    private static final int END_INT = 9;

    private ArrayList<Car> carList;
    private int count;

    public RacingService(ArrayList<Car> carList, int count) {
        this.carList = carList;
        this.count = count;
    }

    public boolean checkForwardMovable() {
        int randomValue = generateRandomForwardValue();
        boolean isForwardMovable = false;

        if (randomValue >= 4) {
            isForwardMovable = true;
        }
        return isForwardMovable;
    }

    public int generateRandomForwardValue() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(START_INT, END_INT);
    }
}
