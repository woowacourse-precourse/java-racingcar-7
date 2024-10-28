package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars;
    private int attempts;

    public Racing(String[] carNames, int attempts) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        this.attempts = attempts;
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            moveCars();
            OutputView.printCarsPostions(cars.toArray(new Car[0]));
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            moveCar(car);
        }
    }
    private void moveCar(Car car) {
        if (shouldMove()) {
            car.move();
        }
    }

    public String getWinnerNames(int maxPosition) {
        StringBuilder winners = new StringBuilder();
        for (Car car : cars) {
            addWinnerNameIfMatch(winners, car, maxPosition);
        }
        return removeLastComma(winners);
    }

    public int findMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPosition());
        }
        return max;
    }

    public void addWinnerNameIfMatch(StringBuilder winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.append(car.getName()).append(",");
        }
    }

    public boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public String removeLastComma(StringBuilder winners) {
        return winners.substring(0, winners.length() - 1);
    }

    public List<Car> getCars() {
        return cars;
    }
}