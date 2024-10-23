package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RaceResponse {
    private List<String> winners;

    public RaceResponse() {
        this.winners = new ArrayList<>();
    }

    public void updateWinners(List<String> winners) {
        this.winners = winners;
    }

    public List<String> winners() {
        return winners;
    }
}
