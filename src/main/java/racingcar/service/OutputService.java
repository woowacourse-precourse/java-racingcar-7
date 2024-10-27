package racingcar.service;

import java.util.List;
import racingcar.dto.RacingCar;

public interface OutputService {
    public void notYetFinish(List<RacingCar> rcList);
    public void finish(List<RacingCar> rcList);
}
