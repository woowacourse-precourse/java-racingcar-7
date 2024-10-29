package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingHistoryDto;
import racingcar.dto.RacingHistoryDto.RacingHistoryOutputDto;
import racingcar.model.domain.RacingHistory;
import racingcar.repository.InMemoryRacingHistoryRepository;

class RacingHistoryServiceImplTest {
    RacingHistoryServiceImpl racingHistoryService;
    InMemoryRacingHistoryRepository racingHistoryRepository;

    @BeforeEach
    void setUp() {
        racingHistoryRepository = InMemoryRacingHistoryRepository.getInstance();
        racingHistoryService = new RacingHistoryServiceImpl(racingHistoryRepository);
        racingHistoryRepository.clear();
    }

    @Test
    void 라운드별_기록_조회_테스트() {
        //given
        RacingHistory racingHistory1 = new RacingHistory("test1", 0, 1);
        RacingHistory racingHistory2 = new RacingHistory("test1", 1, 2);
        racingHistoryRepository.save(racingHistory1);
        racingHistoryRepository.save(racingHistory2);

        //when
        List<RacingHistoryOutputDto> round0 = racingHistoryService.findHistoryByRound(0);
        List<RacingHistoryOutputDto> round1 = racingHistoryService.findHistoryByRound(1);

        //then
        assertThat(List.of(new RacingHistoryDto.RacingHistoryOutputDto(racingHistory1.getCarName(),
                racingHistory1.getRoundNumber(), racingHistory1.getTotalMovedDistance())))
                .isEqualTo(round0);
        assertThat(List.of(new RacingHistoryDto.RacingHistoryOutputDto(racingHistory2.getCarName(),
                racingHistory2.getRoundNumber(), racingHistory2.getTotalMovedDistance())))
                .isEqualTo(round1);
    }
}
