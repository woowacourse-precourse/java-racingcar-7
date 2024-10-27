package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Racing {

    List<Car> carList;

    public Racing(List<Car> carList) {
        this.carList = new ArrayList<>(carList);
    }

    public void runRacingTurn() {
        for (final Car car : carList) {
            car.goOrStop();
        }
    }

    public List<String> computeWinner() {
        List<String> winners = new ArrayList<>();
        int fastest = 0;

        for (final Car car : this.carList) {
            if (fastest < car.getFinalDistance()) {
                fastest = car.getFinalDistance();
                winners.clear();
                winners.add(car.getName());
            } else if (fastest == car.getFinalDistance()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}