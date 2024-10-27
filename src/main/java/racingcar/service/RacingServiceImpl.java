package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.dto.RacingCar;

public class RacingServiceImpl implements RacingService {
    private static final RacingService racingServiceInstance = new RacingServiceImpl();

    private RacingServiceImpl() {
    }

    public static RacingService getInstance() {
        return racingServiceInstance;
    }

    @Override
    public boolean checkCanMoveUseRandomNum() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    @Override
    public List<RacingCar> oneCycle(List<RacingCar> rcList) {
        for (RacingCar rc : rcList) {
            if (checkCanMoveUseRandomNum()) {
                rc.incrementMove();
            }
        }

        return rcList;
    }
}
