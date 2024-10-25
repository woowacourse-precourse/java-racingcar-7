package racingcar.utils;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.dto.RoundResult;
import racingcar.dto.Winners;

public class DisplayConverter {
    public static String convertRoundResult(RoundResult roundResult) {
        List<CarDto> carDtoList = roundResult.getCarDtoList();
        return carDtoList.stream().map(DisplayConverter::convertCarStatus)
                .collect(Collectors.joining("\n"));

    }

    private static String convertCarStatus(CarDto carDto) {
        String progressBar = "";
        for (int i = 0; i < carDto.getCurrentPosition(); i++) {
            progressBar += "-";
        }
        return carDto.getCarName() + " : " + progressBar;
    }

    public static String convertWinners(Winners winners) {
        return winners.getNames().stream().
                collect(Collectors.joining(", "));
    }
}
