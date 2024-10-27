package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;
import racingcar.dto.RacingHistoryDto.RacingHistoryOutputDto;

public interface OutputView {
    void printOutputStart();

    void printRacingHistoryByRound(List<RacingHistoryOutputDto> racingHistoryOutputDto);

    void printWinner(List<CarDto.CarOutputDto> carOutputDtoList);

}
