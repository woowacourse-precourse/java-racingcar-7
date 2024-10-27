package racingcar.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Distance;
import racingcar.exception.InvalidCarNameException.NameLengthExceededExceptionInvalid;
import racingcar.exception.InvalidCarNameException.NameLengthShortExceptionInvalid;

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
                    .isInstanceOf(NameLengthShortExceptionInvalid.class)
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
                    .isInstanceOf(NameLengthExceededExceptionInvalid.class)
                    .hasMessage("자동차 이름은 최대 10자까지 가능합니다.");
        }
    }

    @DisplayName("플레이어 이동하기")
    @Nested
    class 플레이어_이동하기 {

        @DisplayName("새로운 위치로 플레이어 이동")
        @Test
        void 새로운_위치로_플레이어_이동() {
            // given
            final int amount = 10;

            Distance newDistance = Distance.of(amount);
            Distance zeroDistance = Distance.zero();

            // when
            Distance changedDistance = zeroDistance.add(newDistance);

            // then
            final int changedDistanceValue = changedDistance.getValue();
            Assertions.assertThat(changedDistanceValue).isEqualTo(10);

        }
    }

    @DisplayName("플레이어 조회하기")
    @Nested
    class 플레이어_조회하기 {

        @DisplayName("플레이어 ID 조회")
        @Test
        void 플레이어_ID_조회() {
            // given
            final Long validId = 1L;
            final String validName = "name";

            Player player = Player.of(1L, validName);

            // when
            Long playerId = player.getId();

            // then
            Assertions.assertThat(playerId).isEqualTo(1L);
        }

        @DisplayName("플레이어 이름 조회")
        @Test
        void 플레이어_이름_조회() {
            // given
            final Long validId = 1L;
            final String validName = "name";

            Player player = Player.of(1L, validName);

            // when
            String playerName = player.getName();

            // then
            Assertions.assertThat(playerName).isEqualTo("name");

        }

        @DisplayName("플레이어 위치 조회")
        @Test
        void 플레이어_위치_조회() {
            // given
            final Long validId = 1L;
            final String validName = "name";
            final Distance fiveDistance = Distance.of(5);

            Player player = Player.of(1L, validName);
            Player movedPlayer = player.move(fiveDistance);

            // when
            int distanceValue = movedPlayer.getDistanceValue();

            // then
            Assertions.assertThat(distanceValue).isEqualTo(5);

        }
    }


}