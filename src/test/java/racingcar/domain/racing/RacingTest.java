package racingcar.domain.racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarType;

class RacingTest {

    RacingConfig racingConfig;
    Racing racing;

    @BeforeEach
    void init() {
        racingConfig = new RacingConfig("test1,test2,test3", "5", CarType.REGULAR);
        racing = new Racing(racingConfig);
    }

    @Test
    @DisplayName("총 라운드 조회")
    void getTotalRounds() {
        //given
        long expected = 5;

        //when
        long actual = racing.getTotalRounds();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("라운드 진행")
    void playRound() {
        //when & then
        assertThatCode(racing::playRound).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("라운드 진행 - 남은 라운드가 없는 경우")
    void playRoundWithNoMoreRounds() {
        //when
        for (int i = 0; i < 5; i++) {
            playRound();
        }

        //then
        assertThatThrownBy(racing::playRound).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("현재 라운트 상태 조회 - 라운드를 진행하지 않은 경우")
    void getCurrentPosition() {
        //given
        Map<String, Long> expected = new LinkedHashMap<>(Map.of("test1", 0L, "test2", 0L, "test3", 0L));

        //when
        Map<String, Long> actual = racing.getCurrentPosition();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("현재 라운트 상태 조회 - 라운드를 진행한 경우")
    void getCurrentPositionAfterPlayRound() {
        //given
        Map<String, Long> expected = new LinkedHashMap<>(Map.of("test1", 1L, "test2", 1L, "test3", 1L));

        //when
        racing.playRound();
        Map<String, Long> actual = racing.getCurrentPosition();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}