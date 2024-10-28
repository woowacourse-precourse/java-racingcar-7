package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int trialCount;

    public RacingGame(List<String> carNames, int trialCount) {
        this.cars = createCars(carNames);
        this.trialCount = trialCount;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void play() {
        for (int i = 0; i < trialCount; i++) {
            moveCars();
            ResultView.printRoundResult(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}