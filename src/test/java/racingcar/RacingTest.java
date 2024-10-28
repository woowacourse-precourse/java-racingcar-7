package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Racing racing;

    @BeforeEach
    void setUp(){
        Car car1 = new Car("pobi");
        Car car2 = new Car("woin");
        Car car3 = new Car("jun");
        List<Car> carList = new ArrayList<>(Arrays.asList(car1, car2, car3));
        long attemptNumber = 1L;
        this.racing = new Racing(carList, attemptNumber);
    }

    @Test
    @DisplayName("자동차 한 대 전진")
    void moveOneCar() {
        //given
        //when
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    Map<Long, List<Record>> result = racing.race();
                    Assertions.assertThat(result.get(1L).get(0).getMoveCount()).isEqualTo(1);
                    Assertions.assertThat(result.get(1L).get(1).getMoveCount()).isEqualTo(0);
                    Assertions.assertThat(result.get(1L).get(1).getMoveCount()).isEqualTo(0);
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("자동차 한 대 우승")
    void winnerOne() {
        //given
        //when
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    racing.race();
                    List<String> winners = racing.selectWinnerNames();
                    Assertions.assertThat(winners)
                            .hasSize(1)
                            .contains("pobi");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }
}
