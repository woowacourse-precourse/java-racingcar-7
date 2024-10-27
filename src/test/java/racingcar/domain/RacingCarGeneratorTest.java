package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.car.RacingCar;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarGeneratorTest {

    @Test
    public void generateRacingCarListTest() {
        // given
        String carNameListInput = "pobi,woni,jun";

        // when
        List<RacingCar> racingCarList = RacingCarGenerator.generateRacingCarList(carNameListInput);
        List<String> carNameList = List.of(carNameListInput.split(","));

        // then
        for(Object o : racingCarList) {
            Assertions.assertTrue(o instanceof RacingCar);
        }

        for(int i=0; i<racingCarList.size(); i++) {
            Assertions.assertEquals(carNameList.get(i), racingCarList.get(i).getName());
        }
    }

}