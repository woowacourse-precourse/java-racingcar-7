package racingcar.repository;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.player.Player;

@DisplayName("플레이어 레파지토리(PlayerRepository) 유스케이스")
class MemoryPlayerRepositoryTest {

    @DisplayName("플레이어 저장하기")
    @Nested
    class 플레이어_저장하기 {

        @DisplayName("정상적인 플레이어 저장")
        @Test
        void 정상적인_플레이어_저장() {
            // given
            PlayerRepository playerRepository = new MemoryPlayerRepository();
            final Player player = Player.of(1L, "p1");

            // expect
            Assertions.assertThatCode(() -> playerRepository.save(player))
                    .doesNotThrowAnyException();
        }

    }

    @DisplayName("단일 플레이어 id로 조회하기")
    @Nested
    class 단일_플레이어_id로_조회하기 {

        @DisplayName("정상적인 단일 플레이어 조회")
        @Test
        void 정상적인_단일_플레이어_조회() {
            // given
            final Long playerId = 1L;
            PlayerRepository playerRepository = new MemoryPlayerRepository();
            final Player player = Player.of(playerId, "p1");
            playerRepository.save(player);

            // when
            Player gotsPlayer = playerRepository.findById(playerId);

            // then
            Assertions.assertThat(gotsPlayer.getId()).isEqualTo(playerId);

        }

    }

    @DisplayName("플레이어 전체 조회하기")
    @Nested
    class 플레이어_전체_조회하기 {

        @DisplayName("정상적인 전체 플레이어 조회")
        @Test
        void 정상적인_전체_플레이어_조회() {

            // given
            final Player player1 = Player.of(1L, "p1");
            final Player player2 = Player.of(2L, "p1");

            PlayerRepository playerRepository = new MemoryPlayerRepository();
            playerRepository.save(player1);
            playerRepository.save(player2);

            // when
            List<Player> gotPlayers = playerRepository.findAll();

            // then
            final int sizeOfPlayers = gotPlayers.size();
            Assertions.assertThat(sizeOfPlayers).isEqualTo(2);

        }
    }

}