package racingcar.utils;

import static racingcar.constants.FormatConstants.BAR;
import static racingcar.constants.FormatConstants.CAR_STATUS_DELIMITER;
import static racingcar.constants.FormatConstants.CAR_STATUS_DISPLAY_FORMAT;
import static racingcar.constants.FormatConstants.NEXT_LINE;
import static racingcar.constants.FormatConstants.WINNER_DELIMITER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.RoundResult;
import racingcar.dto.Winners;

public class DisplayConverter {
    public static String convertRoundResult(RoundResult roundResult) {
        List<CarDto> carDtoList = roundResult.getCarDtoList();
        return carDtoList.stream().map(DisplayConverter::convertCarStatus)
                .collect(Collectors.joining(NEXT_LINE));

    }

    private static String convertCarStatus(CarDto carDto) {
        StringBuilder progressBar = new StringBuilder();
        for (int i = 0; i < carDto.getCurrentPosition(); i++) {
            progressBar.append(BAR);
        }
        return String.format(CAR_STATUS_DISPLAY_FORMAT, carDto.getCarName(), CAR_STATUS_DELIMITER, progressBar);

    }

    public static String convertWinners(Winners winners) {
        return winners.getWinnerNames().stream().
                collect(Collectors.joining(WINNER_DELIMITER));
    }
}
