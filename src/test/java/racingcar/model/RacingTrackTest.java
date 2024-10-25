package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingTrackException;

class RacingTrackTest {

    @Test
    @DisplayName("중복된 이름이 존재하는 경우 예외 발생")
    void checkDuplicatedCarName() {
        //given
        RacingTrack racingTrack = new RacingTrack();
        final List<String> carNames = List.of("pobi", "pobi", "crong");

        //when & then
        assertThatThrownBy(() -> racingTrack.addCar(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacingTrackException.DUPLICATED_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("중복된 이름이 존재하지 않는 경우 예외 발생하지 않음")
    void checkDuplicatedCarName_NotExist() {
        //given
        RacingTrack racingTrack = new RacingTrack();
        final List<String> carNames = List.of("pobi", "crong");

        //when & then
        assertThatCode(() -> racingTrack.addCar(carNames))
                .doesNotThrowAnyException();
    }

}