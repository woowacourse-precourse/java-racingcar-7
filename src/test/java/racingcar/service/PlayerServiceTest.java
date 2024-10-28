package racingcar.service;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.player.Player;
import racingcar.exception.car.InvalidCarNameException;
import racingcar.repository.MemoryPlayerRepository;
import racingcar.repository.PlayerRepository;
import racingcar.util.IdGenerator;

@DisplayName("플레이어 서비스(PlayerService) 유스케이스")
class PlayerServiceTest {

    @DisplayName("플레이어 등록하기")
    @Nested
    class 플레이어_등록하기 {

        @DisplayName("정상적인 플레이어 등록")
        @Test
        void 정상적인_플레이어_등록() {
            // given
            PlayerRepository playerRepository = new MemoryPlayerRepository();
            IdGenerator idGenerator = new IdGenerator();
            PlayerService playerService = new PlayerService(playerRepository, idGenerator);
            List<String> playerNames = List.of("p1", "p2", "p3");

            // when
            Assertions.assertThatCode(() -> playerService.register(playerNames))
                    .doesNotThrowAnyException();
        }

        @DisplayName("부적절한 이름으로 등록 시도")
        @Test
        void 부적절한_이름으로_등록_시도() {
            // given
            PlayerRepository playerRepository = new MemoryPlayerRepository();
            IdGenerator idGenerator = new IdGenerator();
            PlayerService playerService = new PlayerService(playerRepository, idGenerator);
            List<String> playerNames = List.of("", "", "");

            // when
            Assertions.assertThatThrownBy(() -> playerService.register(playerNames))
                    .isInstanceOf(InvalidCarNameException.class)
                    .hasMessage("자동차 이름은 최소 1자부터 가능합니다.");
        }
    }

    @DisplayName("플레이어 전체 조회하기")
    @Nested
    class 플레이어_전체_조회하기 {

        @DisplayName("정상적인 플레이어 전체 조회")
        @Test
        void 정상적인_플레이어_전체_조회() {
            // given
            PlayerRepository playerRepository = new MemoryPlayerRepository();
            IdGenerator idGenerator = new IdGenerator();
            PlayerService playerService = new PlayerService(playerRepository, idGenerator);
            List<String> playerNames = List.of("p1", "p2", "p3");
            playerService.register(playerNames);

            // when
            List<Player> players = playerService.getAllPlayers();

            // then
            Assertions.assertThat(players).hasSize(3);
        }
    }

}