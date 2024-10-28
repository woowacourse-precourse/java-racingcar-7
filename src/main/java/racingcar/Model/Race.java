package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final int DICE_START_NUMBER = 0;
    private static final int DICE_END_NUMBER = 9;
    private static final int FORWARD_CONDITION = 4;

    private List<Car> cars;
    private int round;

    public List<Car> getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }

    public Race(List<Car> cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void play() {
        executeRound();
    }

    private void executeRound() {
        for (Car car : cars) {
            int dice = Randoms.pickNumberInRange(DICE_START_NUMBER, DICE_END_NUMBER);
            if (dice >= FORWARD_CONDITION) {
                car.forward();
            }
        }
    }

    public List<Car> getWinners() {
        int first = findFirstLocation(cars);
        return getCarsAt(first);
    }

    private int findFirstLocation(List<Car> cars) {
        int first = 0;

        for (Car car : cars) {
            first = Math.max(first, car.getLocation());
        }

        return first;
    }

    private List<Car> getCarsAt(int location) {
        List<Car> findCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.isAtLocation(location)) {
                findCars.add(car);
            }
        }

        return findCars;
    }
}
