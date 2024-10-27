package racingcar.view.output;

import java.util.stream.Collectors;
import racingcar.dto.response.CarRoundStateDTO;
import racingcar.dto.response.RacingResponseDTO;
import racingcar.dto.response.RoundResultDTO;

final class OutputResolver {
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String NAME_MOVE_COUNT_SEPARATOR = " : ";
    private static final String RACE_RESULT_PREFIX = "실행 결과";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private OutputResolver() {
    }

    static String resolveRacingResult(RacingResponseDTO response) {
        String roundResults = response.roundResultDTOs().stream()
                .map(OutputResolver::formatRoundResult)
                .collect(Collectors.joining(LINE_SEPARATOR + LINE_SEPARATOR));

        String winners = String.join(", ", response.winnerNames());

        return buildFinalResult(roundResults, winners);
    }

    private static String formatRoundResult(RoundResultDTO roundResultDTO) {
        return roundResultDTO.carRoundStateDTOs().stream()
                .map(OutputResolver::formatCarRoundState)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private static String formatCarRoundState(CarRoundStateDTO carRoundStateDTO) {
        return String.format("%s%s%s",
                carRoundStateDTO.name(),
                NAME_MOVE_COUNT_SEPARATOR,
                "-".repeat(carRoundStateDTO.moveCount()));
    }

    private static String buildFinalResult(String roundResults, String winners) {
        return LINE_SEPARATOR + String.join(LINE_SEPARATOR,
                RACE_RESULT_PREFIX,
                roundResults,
                "",
                WINNER_MESSAGE_PREFIX + winners
        );
    }
}
