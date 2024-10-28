package racingcar.model;

import java.util.List;

public class Winners {
    private List<String> winnerNames;

    public Winners(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
