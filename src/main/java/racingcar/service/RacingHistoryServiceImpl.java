package racingcar.service;

import java.util.List;
import racingcar.converter.RacingHistoryConverter;
import racingcar.dto.RacingHistoryDto.RacingHistoryOutputDto;
import racingcar.model.domain.RacingHistory;
import racingcar.repository.RacingHistoryRepository;

public class RacingHistoryServiceImpl implements RacingHistoryService {
    private final RacingHistoryRepository racingHistoryRepository;

    public RacingHistoryServiceImpl(RacingHistoryRepository racingHistoryRepository) {
        this.racingHistoryRepository = racingHistoryRepository;
    }

    @Override
    public List<RacingHistoryOutputDto> findHistoryByRound(int roundNumber) {
        List<RacingHistory> racingHistoryList = racingHistoryRepository.findByRoundNumber(roundNumber);
        return RacingHistoryConverter.toRacingHistoryOutputDtoList(racingHistoryList);
    }
}
