package racingcar.view.output;

import racingcar.dto.response.CarRoundStateDTO;

final class OutputResolver {
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String NAME_MOVE_COUNT_SEPARATOR = " : ";
    private static final String RACE_RESULT_PREFIX = "실행 결과";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private OutputResolver() {
    }

    private static String formatCarRoundState(CarRoundStateDTO carRoundStateDTO) {
        return String.format("%s%s%s",
                carRoundStateDTO.name(),
                NAME_MOVE_COUNT_SEPARATOR,
                "-".repeat(carRoundStateDTO.moveCount()));
    }
}
