package racingcar.model;

import java.util.List;

public class Race {
    private int roundCount;
    private Random random;

    public Race(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void roundMove(List<Car> carList) {
        for(Car car : carList)
            moveCheck(car);
        minusRoundCount();
    }

    private void moveCheck(Car car) {
        if(random.getRandom() >= 4)
            car.move();
    }

    private void minusRoundCount() {
        roundCount--;
    }
}
