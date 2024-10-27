package racingcar.test.controllerRaceTest;

import org.junit.jupiter.api.Test;
import racingcar.controller.race.RacingCarController;
import racingcar.controller.race.RacingCarControllerEmb;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarEmb;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarControllerTestEmb implements RacingCarControllerTest {
    @Test
    public void testMoveForward(){
        RacingCarController racingCarController = new RacingCarControllerEmb();
        RacingCar racingCar = new RacingCarEmb("A");
        racingCarController.moveForward(racingCar);
        ArrayList<Integer> oneOrZero = new ArrayList<>();
        oneOrZero.add(1);
        oneOrZero.add(0);
        assertThat(racingCar.getDistance()).isIn(oneOrZero);
    }
}
