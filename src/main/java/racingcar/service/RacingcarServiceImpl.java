package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Racingcar;

import java.util.List;

public class RacingcarServiceImpl implements RacingcarService {
    private static final RacingcarServiceImpl instance = new RacingcarServiceImpl();

    private RacingcarServiceImpl() {}

    public static RacingcarServiceImpl getInstance() {
        return instance;
    }

    @Override
    public void startRaceByCount(List<Racingcar> racingcars) {
        for (Racingcar racingcar: racingcars) {
            if (checkRandomValue()) {
                racingcar.move();
            }
        }
    }

    private boolean checkRandomValue() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
