package racingcar.value;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarListTest {

    private RacingCar car1;
    private RacingCar car2;
    private RacingCar car3;
    private RacingCarList racingCarList;

    @BeforeEach
    void setUp() {
        car1 = RacingCar.initAndFrom(new Player("Alice"));
        car2 = RacingCar.initAndFrom(new Player("Bob"));
        car3 = RacingCar.initAndFrom(new Player("Charlie"));

        racingCarList = new RacingCarList(Arrays.asList(car1, car2, car3));
    }

    @Test
    void 자동차_전진에_성공할_것이다() {
        racingCarList.action(car -> car.getDistance().increase());

        assertAll(
            () -> assertThat(car1.getDistance().getValue()).isEqualTo(1L),
            () -> assertThat(car2.getDistance().getValue()).isEqualTo(1L),
            () -> assertThat(car3.getDistance().getValue()).isEqualTo(1L)
        );
    }

    @Test
    void 전진_결과_메시지_생성에_성공할_것이다() {
        final var result = new StringBuilder();

        racingCarList.actionPrint(list -> {
            list.action(car -> result.append(car.getPlayer().name()).append(" "));
        });

        assertThat(result.toString().trim()).isEqualTo("Alice Bob Charlie");
    }

    @Test
    void 승리자_리스트_생성에_성공할_것이다() {
        final var winnersList = racingCarList.getWinnersList();

        assertAll(
            () -> assertThat(winnersList).isNotNull(),
            () -> {
                assert winnersList != null;
                assertThat(winnersList.list())
                    .hasSize(3)
                    .extracting(Player::name)
                    .containsExactlyInAnyOrder("Alice", "Bob", "Charlie");
            }
        );
    }
}