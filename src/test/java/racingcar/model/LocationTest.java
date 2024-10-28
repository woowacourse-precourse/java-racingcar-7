package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationTest {
    @Test
    void Location_생성_테스트() {
        // given
        int location = 5;

        // when & then
        assertEquals(Location.init(location), Location.init(location));
    }

    @Test
    void Location_move_동작_테스트() {
        // given
        Location location = Location.init(5);
        Location expected = Location.init(6);

        // when
        location.move();

        // then
        assertEquals(location, expected);
    }

    @Test
    void Location_isSame_동작_테스트() {
        // given
        Location location = Location.init(5);

        // when
        int winnerLocation = 5;

        // then
        assertThat(location.isSame(winnerLocation)).isTrue();
    }

    @Test
    void Location_makeProgressBar_동작_테스트() {
        // given & when
        Location location = Location.init(5);

        // then
        assertThat(location.makeProgressBar()).isEqualTo("-----");
    }
}
