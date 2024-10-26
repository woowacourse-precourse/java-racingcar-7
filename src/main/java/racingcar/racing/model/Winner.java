package racingcar.racing.model;

import java.util.List;

public class Winner {
    private final List<Car> participant;
    private List<Car> winners;

    public Winner(List<Car> participant) {
        this.participant = participant;
    }

    public void selectWinners() {

    }

    public List<Car> getWinners() {
        return this.winners;
    }
}
