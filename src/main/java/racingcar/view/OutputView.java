package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {
    public static final String RESULT_MESSAGE = "\n실행 결과";
    public static final String WINNER_MESSAGE = "최종 우승자 : ";
    public static final String POSITION_MESSAGE_DELIMITER = "-";
    public static final String WINNER_MESSAGE_DELIMITER = ", ";

    public void printResult() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCurrentPosition(List<CarDto> carDtos) {
        carDtos.forEach(carDto -> {
            String output = getCurrentPosition(carDto);
            System.out.println(output);
        });
        System.out.println();
    }

    private String getCurrentPosition(CarDto carDto) {
        return carDto.name() + " : " + POSITION_MESSAGE_DELIMITER.repeat(carDto.position());
    }

    public void printWinners(List<String> winners) {
        System.out.print(WINNER_MESSAGE);
        System.out.println(String.join(WINNER_MESSAGE_DELIMITER, winners));
    }
}
