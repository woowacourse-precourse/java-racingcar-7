package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.dto.CarDto;

public class OutputView {

    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String WINNERS_PREFIX = "최종 우승자 : ";
    private static final String CAR_INFIX = " : ";
    private static final String CAR_DELIMITER = ", ";
    private static final String POSITION_CHARACTER = "-";

    public void noticeResult() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printStatusOf(List<CarDto> cars) {
        for (CarDto carDto : cars) {
            printStatusOf(carDto);
        }
        System.out.println();
    }

    private void printStatusOf(CarDto carDto) {
        int fromZeroToPosition = carDto.getPosition();
        String progress = POSITION_CHARACTER.repeat(fromZeroToPosition);
        System.out.println(carDto.getCarName() + CAR_INFIX + progress);
    }

    public void printWinners(List<CarDto> winners) {
        System.out.println(WINNERS_PREFIX + joinNamesOf(winners));
        Console.close();
    }

    private String joinNamesOf(List<CarDto> cars) {
        return cars.stream()
                .map(CarDto::getCarName)
                .collect(Collectors.joining(CAR_DELIMITER));
    }
}
