package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> carList;
    private final int moveCount;
    private int maxScore;

    public Race(List<String> carNames, int moveCount) {
        this.carList = new ArrayList<>();
        for (String carName : carNames) {
            this.carList.add(new Car(carName));
        }
        this.moveCount = moveCount;
        this.maxScore = 0;
    }

    public void runOnce() {
        for (Car car : carList) {
            if (isForwardMovable()) {
                int carScore = car.increaseScore();
                updateMaxScore(carScore);
            }
        }
    }

    public void updateMaxScore(int carScore) {
        if(maxScore < carScore)
            maxScore = carScore;
    }

    public boolean isForwardMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void displayStatus() {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int j = 0; j < car.getScore(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

}
