package racingcar.test.modelTest;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarEmb;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTestEmb implements RacingCarTest {
    @Test
    public void testGetName(){
        RacingCar racingCar = new RacingCarEmb("a");
        assertThat(racingCar.getName()).isEqualTo("a");
    }

    @Test
    public void testGetDistance(){
        RacingCar racingCar = new RacingCarEmb("a");
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }

    @Test
    public void testIncreaseDistance(){
        RacingCar racingCar = new RacingCarEmb("a");
        assertThat(racingCar.getDistance()).isEqualTo(0);
        racingCar.increaseDistance().increaseDistance();
        assertThat(racingCar.getDistance()).isEqualTo(2);
    }

    @Test
    public void run(){
        testGetDistance();
        testGetName();
        testIncreaseDistance();
    }
}
