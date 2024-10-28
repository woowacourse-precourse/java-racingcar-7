package racingcar.converter;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingHistoryDto.RacingHistoryOutputDto;
import racingcar.model.domain.RacingHistory;

class RacingHistoryConverterTest {

    @Test
    void toRacingHistoryOutputDtoList() {
        //given
        List<RacingHistory> racingHistoryList = List.of(new RacingHistory("test1", 0, 0),
                new RacingHistory("test2", 0, 0));

        //when
        List<RacingHistoryOutputDto> racingHistoryOutputDtoList = RacingHistoryConverter.toRacingHistoryOutputDtoList(
                racingHistoryList);

        //then
        Assertions.assertThat(
                        List.of(new RacingHistoryOutputDto("test1", 0, 0), new RacingHistoryOutputDto("test2", 0, 0)))
                .isEqualTo(racingHistoryOutputDtoList);
    }
}
