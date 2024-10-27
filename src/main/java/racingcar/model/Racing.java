package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Racing {
    private int winnerDistance;
    private List<String> winnerNames;

    public Racing(HashSet<Car> cars) {
        this.winnerDistance = 0;
        this.winnerNames = new ArrayList<>();
    }

    public void setWinnerDistance(final int winnerDistance){
        this.winnerDistance = winnerDistance;
    }

    public int getWinnerDistance() {
        return winnerDistance;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
