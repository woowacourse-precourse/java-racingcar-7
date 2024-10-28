package racingcar.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Distance;
import racingcar.exception.player.PlayerException.PlayerExceededException;
import racingcar.exception.player.PlayerException.PlayerUnderstaffedException;

@DisplayName("플레이어 그룹(Players) 유스케이스")
class PlayersTest {

    @DisplayName("플레이어 그룹 생성하기")
    @Nested
    class 플레이어_그룹_생성하기 {

        @DisplayName("정상적인 플레이어 그룹 생성")
        @Test
        void 정상적인_플레이어_그룹_생성() {
            // given
            Player p1 = Player.of(1L, "kim");
            Player p2 = Player.of(2L, "park");
            List<Player> players = List.of(p1, p2);

            // expect
            Assertions.assertThatCode(() -> Players.from(players))
                    .doesNotThrowAnyException();
        }

        @DisplayName("최소 인원 미달로 생성 시도")
        @Test
        void 최소_인원_미달로_생성_시도() {
            // given
            final List<Player> emptyPlayers = List.of(Player.of(1L, "p1"));

            // expect
            Assertions.assertThatThrownBy(() -> Players.from(emptyPlayers))
                    .isInstanceOf(PlayerUnderstaffedException.class)
                    .hasMessage("플레이어는 최소 2명 부터 참여할 수 있습니다");

        }

        @DisplayName("최대 인원 초과로 생성 시도")
        @Test
        void 최대_인원_초과로_생성_시도() {
            // given
            List<Player> exceededPlayers = List.of(
                    Player.of(1L, "p1"),
                    Player.of(2L, "p2"),
                    Player.of(3L, "p3"),
                    Player.of(4L, "p4"),
                    Player.of(5L, "p5"),
                    Player.of(6L, "p6")
            );

            // expect
            Assertions.assertThatThrownBy(() -> Players.from(exceededPlayers))
                    .isInstanceOf(PlayerExceededException.class)
                    .hasMessage("플레이어는 최대 5명 까지 참여할 수 있습니다");

        }

        @DisplayName("중복된 이름으로 생성 성공")
        @Test
        void 중복된_이름으로_생성_성공() {
            // given
            Player p1 = Player.of(1L, "name");
            Player p2 = Player.of(2L, "name");
            List<Player> players = List.of(p1, p2);

            // expect
            Assertions.assertThatCode(() -> Players.from(players))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("플레이어 그룹 업데이트하기")
    @Nested
    class 플레이어_그룹_업데이트하기 {

        @DisplayName("플레이어 그룹 테스트")
        @Nested
        class PlayersGroupTest {
            @DisplayName("플레이어 이동 후 새로운 Players 객체 반환")
            @Test
            void movePlayersAndReturnNewObject() {
                // given
                final Player player1 = Player.of(1L, "p1");
                final Player player2 = Player.of(2L, "p2");
                final Players originalPlayers = Players.from(List.of(player1, player2));
                final Distance distance = Distance.of(1);

                // when
                Players newPlayers = originalPlayers.move(player -> player.move(distance));

                // then
                Assertions.assertThat(newPlayers).isNotSameAs(originalPlayers);
            }
        }

        @DisplayName("전체 플레이어 조회하기")
        @Nested
        class GetAllPlayersTest {

            @DisplayName("모든 플레이어 목록 조회")
            @Test
            void getAllPlayers() {
                // given
                Player p1 = Player.of(1L, "name1");
                p1 = p1.move(Distance.of(10));

                Player p2 = Player.of(2L, "name2");
                p2 = p2.move(Distance.of(20));

                Players players = Players.from(List.of(p1, p2));

                // when
                List<Player> result = players.getAll();

                // then
                assertThat(result)
                        .containsExactlyInAnyOrder(p1, p2);
            }
        }

    }
}