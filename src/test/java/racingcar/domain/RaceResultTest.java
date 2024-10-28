package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {
    @Test
    public void findWinnersTest() {
        // given
        String carNameInput = "pobi,woni,jun";
        List<String> carNameList = List.of(carNameInput.split(","));
        List<RacingCar> racingCarList = RacingCarGenerator
                .generateRacingCarList(carNameInput);

        // when
        RaceResult raceResult = new RaceResult(racingCarList);

        // then
        Assertions.assertNotNull(raceResult.findWinners());
        Assertions.assertTrue(carNameList.containsAll(raceResult.findWinners()));
    }

}