package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceRefereeTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("라운드는 음수일 수 없다")
    public void givenNegativeRound_thenThrowException() {
        //given
        int negativeRound = -1;

        //when & then
        assertThrows(IllegalArgumentException.class, () -> RaceReferee.from(negativeRound));
    }

    @Test
    @DisplayName("심판은 우승자를 결정한다")
    public void givenRacingCars_thenWinnerIsDeclared() {
        //given
        int round = 1;
        Car pobi = Car.from("pobi");
        Car woni = Car.from("woni");
        RaceReferee referee = RaceReferee.from(round);

        //when
        pobi.move();
        List<String> winners = referee.declareWinnerNames(List.of(pobi, woni));

        //then
        assertThat(winners).containsOnly("pobi");
    }

    @Test
    @DisplayName("라운드를 수행하는 동안 자동차를 움직이게 한다")
    public void whenPlayRound_thenCarCanMove() {
        //given
        int round = 5;
        RaceReferee referee = RaceReferee.from(round);
        Car pobi = Car.from("pobi");
        Car woni = Car.from("woni");
        List<Car> cars = List.of(pobi, woni);

        //when & then
        assertRandomNumberInRangeTest(
            () -> {
                List<Car> movedCars = referee.playRound(cars);
                assertThat(movedCars).filteredOn(car -> car.getPosition() == 1)
                    .containsOnly(pobi);
            },
            MOVING_FORWARD, STOP
        );
    }
}