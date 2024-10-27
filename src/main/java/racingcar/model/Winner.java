package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Car> winnerList;

    public Winner() {
        this.winnerList = new ArrayList<>();
    }

    public List<Car> getWinner() {
        return winnerList;
    }
}
