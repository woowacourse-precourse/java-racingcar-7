package racingcar.io;

import java.util.List;
import java.util.StringJoiner;
import racingcar.constants.OutputMessages;
import racingcar.constants.StringConstants;
import racingcar.dto.CarStatus;
import racingcar.dto.LapResult;
import racingcar.dto.RaceResult;

public class RaceResultParser {

    public String parse(RaceResult raceResult) {
        StringBuilder sb = new StringBuilder();

        appendExecutionResults(sb, raceResult.getLapResults());
        appendWinners(sb, raceResult.getWinners());

        return sb.toString();
    }

    private void appendExecutionResults(StringBuilder sb, List<LapResult> lapResults) {
        sb.append(StringConstants.NEW_LINE)
                .append(OutputMessages.EXECUTION_RESULT)
                .append(StringConstants.NEW_LINE);

        for (LapResult result : lapResults) {
            sb.append(result)
                    .append(StringConstants.NEW_LINE);
        }
    }

    private void appendWinners(StringBuilder sb, List<CarStatus> winners) {
        sb.append(OutputMessages.FINAL_WINNER);

        StringJoiner stringJoiner = new StringJoiner(StringConstants.WINNER_SEPARATOR);
        for (CarStatus winner : winners) {
            stringJoiner.add(winner.getName());
        }
        sb.append(stringJoiner);
    }
}