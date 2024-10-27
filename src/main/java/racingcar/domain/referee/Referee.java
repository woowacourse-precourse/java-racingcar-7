package racingcar.domain.referee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.dto.CarStatus;
import racingcar.dto.LapResult;

public class Referee {

    public List<CarStatus> judgeWinners(List<LapResult> lapResults) {
        LapResult lastLap = getLastLapResult(lapResults);
        List<CarStatus> lastLapCarStatuses = lastLap.getCarStatuses();

        int maxPosition = findMaxPosition(lastLapCarStatuses);

        return findMaxPositionCars(lastLapCarStatuses, maxPosition);
    }

    private static LapResult getLastLapResult(List<LapResult> lapResults) {
        ArrayList<LapResult> sortedLapResults = new ArrayList<>(lapResults);
        Collections.sort(sortedLapResults);
        return sortedLapResults.getLast();
    }

    private static int findMaxPosition(List<CarStatus> lastLapCarStatuses) {
        return lastLapCarStatuses.stream()
                .mapToInt(CarStatus::getPosition)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    private static List<CarStatus> findMaxPositionCars(List<CarStatus> lastLapCarStatuses, int maxPosition) {
        return lastLapCarStatuses.stream()
                .filter(carStatus -> carStatus.getPosition() == maxPosition)
                .toList();
    }
}