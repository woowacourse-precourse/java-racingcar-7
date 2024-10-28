package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingUnitResultList {

    List<RacingUnitResult> racingUnitResultList = new ArrayList<>();

    public void addUnitResult(RacingUnitResult racingUnitResult) {
        this.racingUnitResultList.add(racingUnitResult);
    }

}
