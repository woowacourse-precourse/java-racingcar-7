package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> winner;

    public Winner(List<Car> winner) {
        this.winner = winner;
    }

    public List<String> getWinnerNameList() {
        List<String> winnerName = new ArrayList<>();

        for (Car car : winner) {
            winnerName.add(car.getName());
        }

        return winnerName;
    }
}
