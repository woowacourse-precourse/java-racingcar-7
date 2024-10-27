package racingcar.service;

import java.util.List;
import racingcar.dto.RacingCar;

public interface RacingService {
    public boolean checkCanMoveUseRandomNum();
    public List<RacingCar> oneCycle(List<RacingCar> rcList);
}
