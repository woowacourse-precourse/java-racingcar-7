package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<String> winner;
    private int maxPosition;

    public Winner() {
        this.winner = new ArrayList<>();
    }

    public void comparePosition(Car car) {
        if (car.getPosition() > maxPosition) {
            winner.clear();
            winner.add(car.getName());
            maxPosition = car.getPosition();
            return;
        }

        if (car.getPosition() == maxPosition) {
            winner.add(car.getName());
        }
    }

    public List<String> getWinners() {
        return winner;
    }
}
