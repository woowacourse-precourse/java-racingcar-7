package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int DICE_START_NUMBER = 0;
    private static final int DICE_END_NUMBER = 9;
    private static final int FORWARD_CONDITION = 4;

    private List<Car> carList;
    private int round;

    public List<Car> getCarList() {
        return carList;
    }

    public int getRound() {
        return round;
    }

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

    public List<Car> getWinnerList() {
        int first = findFirstLocation(carList);
        return getCarsAt(first);
    }

    private int findFirstLocation(List<Car> carList) {
        int first = 0;

        for (Car car : carList) {
            first = Math.max(first, car.getLocation());
        }

        return first;
    }

    private List<Car> getCarsAt(int location) {
        List<Car> findCarList = new ArrayList<>();

        for (Car car : carList) {
            if (car.isAtLocation(location)) {
                findCarList.add(car);
            }
        }

        return findCarList;
    }
}
