package racingcar.model;

import static racingcar.model.OutputFormat.FINAL_TOP_RANKER_DELIMITER;
import static racingcar.model.OutputFormat.START_RESULT;
import static racingcar.model.OutputFormat.TWO_LINE_DEVIDE;

import java.util.List;

public class RacingRoundResultRecorder {
    private final StringBuilder recorder;

    public RacingRoundResultRecorder() {
        this.recorder = new StringBuilder(START_RESULT.getFormat());
    }

    public String getRecorderToString() {
        return recorder.toString();
    }

    public void record(String result) {
        recorder.append(result)
                .append(TWO_LINE_DEVIDE.getFormat());
    }

    public void recordTopRanker(List<String> topRankers) {
        recorder.append(OutputFormat.FINAL_TOP_RANKER.getFormat())
                .append(String.join(FINAL_TOP_RANKER_DELIMITER.getFormat(), topRankers));
    }

    public static RacingRoundResultRecorder create() {
        return new RacingRoundResultRecorder();
    }
}
