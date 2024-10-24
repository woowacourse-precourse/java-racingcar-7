package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class RacingTest {
    @Test
    void 경주_상태_출력() {
        //when
        Car pobi = new Car("pobi");
        pobi.increaseDistance();
        pobi.increaseDistance();

        Car woni = new Car("woni");
        woni.increaseDistance();
        woni.increaseDistance();
        woni.increaseDistance();
        woni.increaseDistance();

        Car jun = new Car("jun");
        jun.increaseDistance();
        jun.increaseDistance();
        jun.increaseDistance();

        //given
        Racing racing = new Racing();
        racing.addCar(pobi);
        racing.addCar(woni);
        racing.addCar(jun);

        //then
        assertSimpleTest(() -> {
            assertThat(racing.toString()).isEqualTo("pobi : --\nwoni : ----\njun : ---");
        });
    }
}
