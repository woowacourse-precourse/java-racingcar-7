package racingcar.domain;

import racingcar.dto.CarStatusDto;

import java.util.List;

public class RacingResult {

    private final List<CarStatusDto> carsStatus;

    public RacingResult(List<CarStatusDto> carsStatus) {
        this.carsStatus = carsStatus;
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition(carsStatus);

        return carsStatus.stream()
                .filter(raceResult -> raceResult.position() == maxPosition)
                .map(CarStatusDto::name)
                .toList();
    }

    private int getMaxPosition(List<CarStatusDto> raceResults) {
        return raceResults.stream()
                .mapToInt(CarStatusDto::position)
                .max()
                .orElse(0);
    }
}
