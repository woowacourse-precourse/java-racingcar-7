package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RaceTest extends NsTest {

    @Test
    void 자동차_움직임() {

        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Race race = new Race(Arrays.asList(car1, car2));

        assertRandomNumberInRangeTest(
                () -> {
                    race.move(2);

                    assertThat(car1.getLocation()).isEqualTo(0);
                    assertThat(car2.getLocation()).isEqualTo(2);
                },
                3, 4, 3, 4
        );
    }

    @Override
    public void runMain() {
    }
}