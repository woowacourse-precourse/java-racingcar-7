package racingcar.dto;

import java.util.List;
import java.util.Objects;

public class RaceResult {

    private final List<LapResult> lapResults;
    private final List<CarStatus> winners;

    private RaceResult(List<LapResult> lapResults, List<CarStatus> winners) {
        this.lapResults = lapResults;
        this.winners = winners;
    }

    public static RaceResult of(List<LapResult> lapResults, List<CarStatus> winners) {
        return new RaceResult(lapResults, winners);
    }

    public List<LapResult> getLapResults() {
        return lapResults;
    }

    public List<CarStatus> getWinners() {
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RaceResult that)) {
            return false;
        }
        return Objects.equals(getLapResults(), that.getLapResults()) && Objects.equals(getWinners(),
                that.getWinners());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLapResults(), getWinners());
    }
}
