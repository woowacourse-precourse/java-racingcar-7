package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceStarterTest {

    @Test
    public void startRaceTest() {
        // given
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar("pobi"));
        racingCarList.add(new RacingCar("woni"));
        racingCarList.add(new RacingCar("jun"));

        // when
        RaceStarter.startRace(racingCarList, 100);

        // then
        for(RacingCar racingCar : racingCarList) {
            // 100번 시도하면 확률상 한 번은 움직였을 것. (제대로 동작하는지 테스트, 실패할 수도 있음)
            Assertions.assertNotEquals("", racingCar.getMoveRecord());
        }
    }

}