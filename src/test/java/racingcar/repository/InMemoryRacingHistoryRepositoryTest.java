package racingcar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.RacingHistory;

class InMemoryRacingHistoryRepositoryTest {
    InMemoryRacingHistoryRepository racingHistoryRepository;

    @BeforeEach
    void setUp() {
        racingHistoryRepository = InMemoryRacingHistoryRepository.getInstance();
    }

    @Test
    void 저장_테스트() {
        //given
        RacingHistory racingHistory = new RacingHistory("test1", 0, 1);

        //when
        racingHistoryRepository.save(racingHistory);

        //then
        assertThat(racingHistory.getCarName())
                .isEqualTo(racingHistoryRepository.findByRoundNumber(0).getFirst().getCarName());
    }

    @Test
    void 라운드별_저장_테스트() {
        //given
        RacingHistory racingHistory1 = new RacingHistory("test1", 1, 1);
        RacingHistory racingHistory2 = new RacingHistory("test2", 1, 0);
        RacingHistory racingHistory3 = new RacingHistory("test3", 2, 1);

        //when
        racingHistoryRepository.save(racingHistory1);
        racingHistoryRepository.save(racingHistory2);
        racingHistoryRepository.save(racingHistory3);

        //then
        assertThat(List.of("test1", "test2"))
                .isEqualTo(racingHistoryRepository.findByRoundNumber(1).stream().map(RacingHistory::getCarName).collect(
                        Collectors.toList()));
        assertThat(List.of("test3"))
                .isEqualTo(racingHistoryRepository.findByRoundNumber(2).stream().map(RacingHistory::getCarName).collect(
                        Collectors.toList()));
    }
}
