package racingcar.view;

import java.util.List;
import racingcar.dto.WinnerResponseDto;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";
    private static final String COLON = " : ";
    private static final String COMMA = ", ";
    private static final String POSITION_DISPLAY = "-";

    public static void printRacingOutput(List<WinnerResponseDto> responseDtos) {
        System.out.println(RESULT_MESSAGE);
        responseDtos.forEach(dto -> System.out.println(dto.name() + COLON
                + POSITION_DISPLAY.repeat(dto.position())));
        System.out.println();
    }

    public static void printWinnerOutput(List<String> winners) {
        String winnerNames = String.join(COMMA, winners);
        System.out.println(WINNER_MESSAGE + winnerNames);
    }

}

