package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class DisplayConverter {
    public static String convertRoundResult(RoundResult roundResult) {
        List<CarDto> carDtoList = roundResult.getCarDtoList();
        return carDtoList.stream().map(DisplayConverter::convertCarStatus)
                .collect(Collectors.joining("\n"));

    }

    private static String convertCarStatus(CarDto carDto) {
        return carDto.getCarName()+" : "+carDto.getCurrentPosition();
    }
}
