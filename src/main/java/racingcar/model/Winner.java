package racingcar.model;

import java.util.List;

public class Winner {

    private List<Car> winners;

    public Winner(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
