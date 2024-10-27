package racingcar.racingcar.dto;

import racingcar.constant.separator.SeparatorConstant;
import racingcar.racingcar.domain.RacingCar;

import java.util.Collections;
import java.util.List;

public class RacingCarInfo {
    private final List<RacingCar> racingCarInfo;
    public RacingCarInfo(List<RacingCar> racingCarInfo) {
        this.racingCarInfo = racingCarInfo;
    }
    public List<RacingCar> getRacingCarInfo() {
        return Collections.unmodifiableList(racingCarInfo);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        racingCarInfo.forEach(
                (racingCar) -> sb.append(racingCar).append(SeparatorConstant.NEXT_LINE)
        );
        return sb.toString();
    }

}
