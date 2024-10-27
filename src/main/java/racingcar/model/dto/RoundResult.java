package racingcar.model.dto;


import racingcar.model.gameinfo.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {
    private final List<CarInfo> carInfos;

    public RoundResult(List<CarInfo> carInfos) {
        this.carInfos = carInfos;
    }

    public List<CarInfo> getCarInfos() {
        return new ArrayList<>(carInfos);
    }
}