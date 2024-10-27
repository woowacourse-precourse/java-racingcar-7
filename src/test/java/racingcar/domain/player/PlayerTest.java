package racingcar.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameException.NameLengthExceededException;
import racingcar.exception.CarNameException.NameLengthShortException;

@DisplayName("단일 플레이어(Player) 유스케이스")
class PlayerTest {

    @DisplayName("플레이어 생성하기")
    @Nested
    class 플레이어_생성하기 {
        @DisplayName("정상적인 플레이어 생성")
        void 정상적인_플레이어_생성() {
            // given
            final Long id = 1L;
            final String name = "name";

            // expect
            Assertions.assertThatCode(() -> Player.of(id, name))
                    .doesNotThrowAnyException();
        }

        @DisplayName("잘못된 이름으로 플레이어 생성 시도 - 길이 짧음")
        @Test
        void 잘못된_이름으로_플레이어_생성_시도_길이_짧음() {
            // given
            final Long id = 1L;
            final String unValidName = "";

            // expect
            Assertions.assertThatThrownBy(() -> Player.of(id, unValidName))
                    .isInstanceOf(NameLengthShortException.class)
                    .hasMessage("자동차 이름은 최소 1자부터 가능합니다.");
        }

        @DisplayName("잘못된 이름으로 플레이어 생성 시도 - 길이 길음")
        @Test
        void 잘못된_이름으로_플레이어_생성_시도_길이_길음() {
            // given
            final Long id = 1L;
            final String unValidName = "123456789**";

            // expect
            Assertions.assertThatThrownBy(() -> Player.of(id, unValidName))
                    .isInstanceOf(NameLengthExceededException.class)
                    .hasMessage("자동차 이름은 최대 10자까지 가능합니다.");
        }

    }


}