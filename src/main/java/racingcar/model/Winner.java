package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private final List<String> winner;
    private int maxPosition;

    private Winner() {
        this.winner = new ArrayList<>();
    }

    public static Winner createWinner() {
        return new Winner();
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
        return Collections.unmodifiableList(winner);
    }
}
