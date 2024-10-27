package racingcar;

import java.util.List;

public class RoundStatus {

    private int round;
    private List<CarStatus> carStatusList;

    public RoundStatus(
            int round,
            List<CarStatus> carStatusList
    ) {
        this.round = round;
        this.carStatusList = carStatusList;
    }

    public int getRound() {
        return round;
    }

    public List<CarStatus> getCarStatusList() {
        return carStatusList;
    }
}
