package racingcar.dto;

import java.util.List;

public class RaceResponse {
    private List<String> winners;

    public RaceResponse(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinningCars() {
        return winners;
    }
}
