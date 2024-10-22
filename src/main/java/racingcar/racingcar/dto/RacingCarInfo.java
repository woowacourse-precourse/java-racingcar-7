package racingcar.racingcar.dto;

import racingcar.racingcar.domain.RacingCar;

import java.util.List;

public class RacingCarInfo {
    private final List<RacingCar> racingCarInfo;
    public RacingCarInfo(List<RacingCar> racingCarInfo) {
        this.racingCarInfo = racingCarInfo;
    }
    public List<RacingCar> getRacingCarInfo() {
        return racingCarInfo;
    }
}
