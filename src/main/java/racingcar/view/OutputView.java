package racingcar.view;

import java.util.List;
import racingcar.dto.RacingResponseDto;
import racingcar.model.Car;
import racingcar.model.RoundResult;

public class OutputView {
    private static final String ROUND_RESULT_START_MESSAGE = "실행 결과";

    private final StringBuilder stringBuilder = new StringBuilder();

    public void printRacingResponse(RacingResponseDto racingResponseDto) {
        clearStringBuilder();
        appendRoundResultStartMessage();
        appendAllRoundResults(racingResponseDto.roundResults());
        appendWinners(racingResponseDto.winners());
        System.out.println(stringBuilder.toString());
        clearStringBuilder();
    }

    private void appendRoundResultStartMessage() {
        stringBuilder.append(ROUND_RESULT_START_MESSAGE).append("\n");
    }

    private void appendAllRoundResults(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            appendRoundResult(roundResult);
        }
    }

    private void appendRoundResult(RoundResult roundResult) {
        for (Car car : roundResult.getRoundResult()) {
            appendCarResult(car);
        }
        stringBuilder.append("\n");
    }

    private void appendWinners(List<String> winners) {
        stringBuilder.append("최종 우승자 : ")
                .append(joinWinners(winners))
                .append("\n");
    }

    private void appendCarResult(Car car) {
        stringBuilder.append(car.getName())
                .append(" : ")
                .append(buildDistanceGraph(car.getMovedDistance()))
                .append("\n");
    }

    private String joinWinners(List<String> winners) {
        return String.join(", ", winners);
    }

    private String buildDistanceGraph(int distance) {
        return "-".repeat(distance);
    }

    private void clearStringBuilder() {
        if (!stringBuilder.isEmpty()) {
            stringBuilder.setLength(0);
        }
    }
}
