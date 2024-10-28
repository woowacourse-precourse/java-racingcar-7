package racingcar.dto.request;

import java.util.Map;

public record RacingCarRequest(
        String carName,
        int attemptCount
) {
    public static RacingCarRequest fromMap(Map<String, String> carRacingInfo) {
        String carName = carRacingInfo.get("carName");
        return new RacingCarRequest(carName, Integer.parseInt(carRacingInfo.get("attemptCount")));
    }
}
