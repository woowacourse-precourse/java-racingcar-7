package racingcar.domain.race;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.lap.Lap;
import racingcar.domain.referee.Referee;
import racingcar.dto.CarStatus;
import racingcar.dto.LapResult;
import racingcar.dto.RaceResult;

public class Race {

    private final Lap lap;
    private final Referee referee;

    public Race(Lap lap, Referee referee) {
        this.lap = lap;
        this.referee = referee;
    }

    public RaceResult start(int lapCount) {
        List<LapResult> lapResults = new ArrayList<>();

        for (int i = 0; i < lapCount; i++) {
            lapResults.add(lap.oneLap());
        }

        List<CarStatus> winners = referee.judgeWinners(lapResults);
        return RaceResult.of(lapResults, winners);
    }
}